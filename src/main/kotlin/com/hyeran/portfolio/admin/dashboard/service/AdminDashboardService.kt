package com.hyeran.portfolio.admin.dashboard.service

import com.hyeran.portfolio.admin.data.TableDTO
import com.hyeran.portfolio.domain.entity.HttpInterface
import com.hyeran.portfolio.domain.repository.HttpInterfaceRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class AdminDashboardService(
    private val httpInterfaceRepository: HttpInterfaceRepository
) {
    fun getHttpInterfaceTable(): TableDTO{
        // 최대 100개씩만 역순으로 조회하도록
        val pageRequest = PageRequest.of(0, 100, Sort.Direction.DESC, "id")

        val classInfo = HttpInterface::class
        val entities = httpInterfaceRepository.findAll(pageRequest).content

        return TableDTO.from(classInfo, entities)
    }

    fun countVisitorsTotal(): Long{
        return httpInterfaceRepository.count()
    }


    fun countVisitorsWeekly(): Long{
        //오늘 포함해 7일
        var today = LocalDate.now()
        var startDay = today.minusDays(6) // 6일전까지

        return httpInterfaceRepository.countAllByCreatedDateTimeBetween(startDay.atStartOfDay(), today.atTime(LocalTime.MAX))
    }
    fun countVisitorsToday(): Long{
        //오늘 포함해 7일
        var today = LocalDate.now()

        return httpInterfaceRepository.countAllByCreatedDateTimeBetween(today.atStartOfDay(), today.atTime(LocalTime.MAX))
    }


}