package com.hyeran.portfolio.domain.repository

import com.hyeran.portfolio.domain.constant.SkillType
import com.hyeran.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SkillRepository : JpaRepository<Skill, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Skill>

    // select * from skill where lower(name) = lower(:name) and skill_type = :type
    // -> 아래 함수로 jpa에서 자동으로 소문자 변환하는 쿼리를 자동으로 변환해줌
    fun findByNameIgnoreCaseAndType(name: String, type: SkillType): Optional<SkillType>

}