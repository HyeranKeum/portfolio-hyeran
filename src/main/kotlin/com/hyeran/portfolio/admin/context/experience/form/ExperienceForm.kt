package com.hyeran.portfolio.admin.context.experience.form

import com.hyeran.portfolio.domain.entity.Experience
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

class ExperienceForm(
    @field:NotBlank(message = "핗수값입니다.")
    val title: String,
    @field:NotBlank(message = "핗수값입니다.")
    val description: String,
    @field:Positive(message = "0보다 커야 합니다.")
    val startYear: Int,

    val startMonth: Int,

    val endYear: Int,

    val endMonth: Int,

    val isActive: Boolean,

    val details: List<ExperienceDetailForm>?
) {
    fun toEntity(): Experience {
        return Experience(
            title = this.title,
            description = this.description,
            startYear = this.startYear,
            startMonth = this.startMonth,
            endYear = this.endYear,
            endMonth = this.endMonth,
            isActive = this.isActive,

            )
    }
}