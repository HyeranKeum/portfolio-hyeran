package com.hyeran.portfolio.admin.context.introduction.form

import com.hyeran.portfolio.domain.entity.Introduction
import jakarta.validation.constraints.NotBlank

data class IntroductionForm(
    @field: NotBlank(message = "필수값입니다.")
    val content: String,

    val isActive: Boolean,

    ) {
    // introduction admin에서 삽입
    fun toEntity(): Introduction {
        return Introduction(
            content = this.content,
            isActive = this.isActive
        )
    }

    // introduction admin에서 수정
    fun toEntity(id: Long): Introduction {
        val introduction = this.toEntity() // Introduction 클래스
        introduction.id = id // 수정할 introduction id

        return introduction
    }
}