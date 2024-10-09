package com.hyeran.portfolio.presentation.dto

class ExperienceDTO(
    val title: String,
    val description: String,
    val startYearMonth: String,
    val endYearMonth: String?,
    val details: List<String>
)