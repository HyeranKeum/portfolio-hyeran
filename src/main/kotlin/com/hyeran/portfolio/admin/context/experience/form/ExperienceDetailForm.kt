package com.hyeran.portfolio.admin.context.experience.form

import com.hyeran.portfolio.domain.entity.ExperienceDetail
import jakarta.validation.constraints.NotBlank

data class ExperienceDetailForm(
    val id: Long,

    @field:NotBlank(message = "핗수값입니다.")
    val content: String,

    val isActive: Boolean,
) {
    fun toEntity(): ExperienceDetail {
        return ExperienceDetail(
            content = this.content,
            isActive = this.isActive
        )
    }

}