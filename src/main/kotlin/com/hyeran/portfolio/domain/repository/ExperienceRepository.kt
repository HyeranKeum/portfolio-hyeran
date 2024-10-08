package com.hyeran.portfolio.domain.repository

import com.hyeran.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

/*
N+1 문제 발생
interface ExperienceRepository : JpaRepository<Experience, Long> {

    fun findAllByIsActive(isActive: Boolean): List<Experience>

}*/

interface ExperienceRepository : JpaRepository<Experience, Long> {
    // inner join
    //@Query("select e from Experience e join fetch e.details where e.isActive = :isActive")

    // Experience에 데이터 있으면 무조건 가져오게 되는 left join
    @Query("select e from Experience e left join fetch e.details where e.isActive = :isActive")
    fun findAllByIsActive(isActive: Boolean): List<Experience>

    @Query("select e from Experience e left join fetch e.details where e.id = :id")
    override fun findById(id: Long): Optional<Experience>
}