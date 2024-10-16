package com.hyeran.portfolio.admin.context.skill.controller

import com.hyeran.portfolio.admin.context.skill.form.SkillForm
import com.hyeran.portfolio.admin.context.skill.service.AdminSkillService
import com.hyeran.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/skills")
class AdminSkillApiController(
    private val adminSkillService: AdminSkillService
) {
    // 삽입
    @PostMapping
    fun postSkill(@RequestBody @Validated form: SkillForm): ResponseEntity<Any> {
        adminSkillService.save(form)

        return ApiResponse.successCreate()
    }

    // 수정
    @PutMapping("/{id}")
    fun putSkill(@PathVariable id: Long, @RequestBody form: SkillForm): ResponseEntity<Any> {
        adminSkillService.update(id, form)

        return ApiResponse.successCreate()
    }
}