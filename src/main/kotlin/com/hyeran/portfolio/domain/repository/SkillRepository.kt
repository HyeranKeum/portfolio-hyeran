package com.hyeran.portfolio.domain.repository

import com.hyeran.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>