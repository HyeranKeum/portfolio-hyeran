package com.hyeran.portfolio.domain.repository

import com.hyeran.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Project>

    // override fun findById(id: Long): Optional<Project>
}