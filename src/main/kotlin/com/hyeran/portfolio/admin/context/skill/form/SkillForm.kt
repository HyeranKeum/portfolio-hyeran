package com.hyeran.portfolio.admin.context.skill.form

import com.hyeran.portfolio.domain.entity.Skill
import jakarta.validation.constraints.NotBlank

class SkillForm(
    @field: NotBlank(message = "필수값입니다.")
    val name: String,
    val type: String,

    val isActive: Boolean,
) {
    fun toEntity(): Skill {
        return Skill(
            name = this.name,
            type = this.type,
            isActive = this.isActive
        )
    }

    // skill admin에서 수정
    fun toEntity(id: Long): Skill {
        val skill = this.toEntity() // Skill 클래스
        skill.id = id // 수정할 skill id

        return skill
    }
}