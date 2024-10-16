package com.hyeran.portfolio.admin.context.link.form

import com.hyeran.portfolio.domain.entity.Link
import jakarta.validation.constraints.NotBlank

data class LinkForm(
    @field: NotBlank(message = "필수값입니다.")
    val name: String,
    val content: String,

    val isActive: Boolean,

    ) {
    // link admin에서 삽입
    fun toEntity(): Link {
        return Link(
            name = this.name,
            content = this.content,
            isActive = this.isActive
        )
    }

    // link admin에서 수정
    fun toEntity(id: Long): Link {
        val link = this.toEntity() // Link 클래스
        link.id = id // 수정할 link id

        return link
    }
}