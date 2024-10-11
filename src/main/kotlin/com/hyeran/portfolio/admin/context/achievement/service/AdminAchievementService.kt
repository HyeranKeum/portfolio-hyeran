package com.hyeran.portfolio.admin.context.achievement.service

import com.hyeran.portfolio.admin.data.TableDTO
import com.hyeran.portfolio.domain.entity.Achievement
import com.hyeran.portfolio.domain.repository.AchievementRepository
import org.springframework.stereotype.Service

@Service
class AdminAchievementService(
    private val achievementRepository: AchievementRepository
) {

    fun getAchievementTable(): TableDTO {
        val classInfo = Achievement::class
        val entities = achievementRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}