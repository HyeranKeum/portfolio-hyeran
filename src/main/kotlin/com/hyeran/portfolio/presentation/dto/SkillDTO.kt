package com.hyeran.portfolio.presentation.dto

import com.hyeran.portfolio.domain.entity.Skill

class SkillDTO(
    val name: String,
    val type: String
) {
    constructor(skill: Skill) : this(
        name = skill.name,
        type = skill.type.name
    )
}