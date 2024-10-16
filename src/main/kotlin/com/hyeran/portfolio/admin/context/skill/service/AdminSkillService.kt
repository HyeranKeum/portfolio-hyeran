package com.hyeran.portfolio.admin.context.skill.service

import com.hyeran.portfolio.admin.context.skill.form.SkillForm
import com.hyeran.portfolio.admin.data.TableDTO
import com.hyeran.portfolio.domain.entity.Skill
import com.hyeran.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {

    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: SkillForm) {
        val skill = form.toEntity()
        skillRepository.save(skill)
    }

    // 수정
    @Transactional
    fun update(id: Long, form: SkillForm) {
        val skill = form.toEntity(id)
        skillRepository.save(skill)
    }

}
