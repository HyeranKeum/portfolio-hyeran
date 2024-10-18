package com.hyeran.portfolio.domain.repository

import com.hyeran.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {

    // 이 사이 넣어준 시간에 방문한 방문자 수를 셀 수 있다.
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime) : Long
}