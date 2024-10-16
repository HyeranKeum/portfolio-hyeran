package com.hyeran.portfolio.admin.context.project.form

import com.hyeran.portfolio.domain.entity.Project
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class ProjectForm(
    @field:NotBlank(message = "핗수값입니다.")
    val name: String,
    @field:NotBlank(message = "핗수값입니다.")
    val description: String,
    @field:Positive(message = "0보다 커야 합니다.")
    val startYear: Int,

    val startMonth: Int,

    val endYear: Int,

    val endMonth: Int,

    val isActive: Boolean,

    val details: List<ProjectDetailForm>?
) {
    fun toEntity(): Project {
        return Project(
            name = this.name,
            description = this.description,
            startYear = this.startYear,
            startMonth = this.startMonth,
            endYear = this.endYear,
            endMonth = this.endMonth,
            isActive = this.isActive,

            )
    }
}