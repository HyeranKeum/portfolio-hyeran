package com.hyeran.portfolio.admin.context.introduction.controller

import com.hyeran.portfolio.admin.context.introduction.form.IntroductionForm
import com.hyeran.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.hyeran.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/introductions")
class AdminIntroductionApiController(
    private val adminIntroductionService: AdminIntroductionService
) {
    // 삽입
    @PostMapping
    fun postIntroduction(@RequestBody @Validated form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(form)

        return ApiResponse.successCreate()
    }

    // 수정
    @PutMapping("/{id}")
    fun putIntroduction(@PathVariable id: Long, @RequestBody form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.update(id, form)

        return ApiResponse.successCreate()
    }
}