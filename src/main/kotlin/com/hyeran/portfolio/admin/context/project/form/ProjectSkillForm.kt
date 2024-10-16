package com.hyeran.portfolio.admin.context.project.form

import jakarta.validation.constraints.NotBlank

class ProjectSkillForm(

    @field:NotBlank(message = "핗수값입니다.")
    val project: String,

    @field:NotBlank(message = "핗수값입니다.")
    val skill: String,
)