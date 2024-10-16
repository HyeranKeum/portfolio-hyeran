package com.hyeran.portfolio.admin.context.introduction.service

import com.hyeran.portfolio.admin.context.introduction.form.IntroductionForm
import com.hyeran.portfolio.admin.data.TableDTO
import com.hyeran.portfolio.domain.entity.Introduction
import com.hyeran.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {
    // 조회
    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }

    // 삽입
    @Transactional
    fun save(form: IntroductionForm) {
        val introduction = form.toEntity()
        introductionRepository.save(introduction)
    }

    // 수정
    @Transactional
    fun update(id: Long, form: IntroductionForm) {
        val introduction = form.toEntity(id)
        introductionRepository.save(introduction)
    }
}
