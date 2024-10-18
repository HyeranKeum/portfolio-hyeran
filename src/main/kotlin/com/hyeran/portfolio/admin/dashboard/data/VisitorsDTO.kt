package com.hyeran.portfolio.admin.dashboard.data

data class VisitorsDTO(
    val name: String,
    val count: Long,
    val color: String, // 색깔 hex코드
    val background: String // 카드 색깔

) {
}