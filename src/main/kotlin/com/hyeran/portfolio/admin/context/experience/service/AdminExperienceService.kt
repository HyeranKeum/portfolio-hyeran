package com.hyeran.portfolio.admin.context.experience.service

import com.hyeran.portfolio.admin.context.experience.form.ExperienceForm
import com.hyeran.portfolio.admin.data.TableDTO
import com.hyeran.portfolio.admin.exception.AdminBadRequestException
import com.hyeran.portfolio.domain.entity.Experience
import com.hyeran.portfolio.domain.entity.ExperienceDetail
import com.hyeran.portfolio.domain.repository.ExperienceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// experience table 조회, experience detail table 조회
@Service
class AdminExperienceService(
    private val experienceRepository: ExperienceRepository
) {
    fun getExperienceTable(): TableDTO {
        val classInfo = Experience::class
        val entities = experienceRepository.findAll()

        return TableDTO.from(classInfo, entities, "details")
    }

    fun getExperienceDetailTable(id: Long?): TableDTO {
        val classInfo = ExperienceDetail::class
        val entities = if (id != null) experienceRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }
            .details
        else emptyList()

        return TableDTO.from(classInfo, entities)
    }

    // 삽입
    @Transactional
    fun save(form: ExperienceForm) {
        val experienceDetails = form.details
            ?.map { it.toEntity() } // null이 아닐경우.
            ?.toMutableList() //
        val experience = form.toEntity()
        experience.addDetails(experienceDetails)

        experienceRepository.save(experience)
        // ->cascadetype.all이어서 experience detail을 저장하지 않아도 위 코드 한 줄로 알아서 처리
    }

    //수정
    @Transactional
    fun update(id: Long, form: ExperienceForm) {
        val experience = experienceRepository.findById(id) // 수정 요청한 애 id 있나 찾아보기
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }
        // id가 존재하면
        experience.update(
            title = form.title,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endYear = form.endYear,
            endMonth = form.endMonth,
            isActive = form.isActive
        )

        val detailMap = experience.details.map { it.id to it }.toMap() // detail_id : entity 식으로 키밸류 형태 만들어줌
        form.details?.forEach { // form으로 받아온 데이터에 details가 존재한다면
            val entity = detailMap.get(it.id) // detail id에 대한 entity mapping
            if (entity != null) { // detail에 대한 내용이 존재한다. -> 원래 있던 데이터
                entity.update(
                    content = it.content,
                    isActive = it.isActive
                )
            } else { // ->산규로 추가해준 데이터
                experience.details.add(it.toEntity())
            }
        }
    }
}