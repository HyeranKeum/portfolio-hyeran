package com.hyeran.portfolio.presentation.repository

import com.hyeran.portfolio.domain.entity.*
import com.hyeran.portfolio.domain.repository.*
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val experienceRepository: ExperienceRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository,
) {
    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperience(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroduction(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveLink(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }

    fun getActiveProject(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }

    fun getActiveSkill(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }
}