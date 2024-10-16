package com.hyeran.portfolio.admin.context.experience.controller

import com.hyeran.portfolio.admin.context.experience.form.ExperienceForm
import com.hyeran.portfolio.admin.context.experience.service.AdminExperienceService
import com.hyeran.portfolio.admin.data.ApiResponse
import com.hyeran.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/experiences")
class AdminExperienceApiController(
    private val adminExperienceService: AdminExperienceService
) {
    // 삽입
    @PostMapping
    fun postExperience(@RequestBody @Validated form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.save(form)

        return ApiResponse.successCreate()
    }

    // 수정
    @PutMapping("/{id}")
    fun putExperience(@PathVariable id: Long, @RequestBody form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.update(id, form)

        return ApiResponse.successCreate()
    }

    // detail 가지고 있는 애들은 상세 데이터도 가지고 오도록
    @GetMapping("/{id}/details")
    fun getExperienceDetails(@PathVariable id: Long): TableDTO {
        return adminExperienceService.getExperienceDetailTable(id)
    }
}