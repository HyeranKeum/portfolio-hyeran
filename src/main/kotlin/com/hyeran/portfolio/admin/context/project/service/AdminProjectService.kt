package com.hyeran.portfolio.admin.context.project.service

import com.hyeran.portfolio.admin.context.project.form.ProjectForm
import com.hyeran.portfolio.admin.data.TableDTO
import com.hyeran.portfolio.admin.exception.AdminBadRequestException
import com.hyeran.portfolio.domain.entity.Project
import com.hyeran.portfolio.domain.entity.ProjectDetail
import com.hyeran.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// project table 조회, project detail table 조회
@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {
    @Transactional
    fun getProjectTable(): TableDTO {
        val classInfo = Project::class
        val entities = projectRepository.findAll()

        return TableDTO.from(classInfo, entities, "details, skills")
    }

    @Transactional
    fun getProjectDetailTable(id: Long?): TableDTO {
        val classInfo = ProjectDetail::class
        val entities = if (id != null) projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }
            .details
        else emptyList()

        return TableDTO.from(classInfo, entities)
    }

    // 삽입
    @Transactional
    fun save(form: ProjectForm) {
        val projectDetails = form.details
            ?.map { it.toEntity() } // null이 아닐경우.
            ?.toMutableList() //
        val project = form.toEntity()
        project.addDetails(projectDetails)

        projectRepository.save(project)
        // ->cascadetype.all이어서 project detail을 저장하지 않아도 위 코드 한 줄로 알아서 처리
    }

    //수정 -> detail도
    @Transactional
    fun update(id: Long, form: ProjectForm) {
        val project = projectRepository.findById(id) // 수정 요청한 애 id 있나 찾아보기
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }
        // id가 존재하면
        project.update(
            name = form.name,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endYear = form.endYear,
            endMonth = form.endMonth,
            isActive = form.isActive
        )

        val detailMap = project.details.map { it.id to it }.toMap() // detail_id : entity 식으로 키밸류 형태 만들어줌
        form.details?.forEach { // form으로 받아온 데이터에 details가 존재한다면
            val entity = detailMap.get(it.id) // detail id에 대한 entity mapping
            if (entity != null) { // detail에 대한 내용이 존재한다. -> 원래 있던 데이터
                entity.update(
                    content = it.content,
                    url = it.url,
                    isActive = it.isActive
                )
            } else { // ->산규로 추가해준 데이터
                project.details.add(it.toEntity())
            }
        }
    }

}