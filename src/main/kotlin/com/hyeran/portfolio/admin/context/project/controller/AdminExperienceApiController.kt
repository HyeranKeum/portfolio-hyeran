package com.hyeran.portfolio.admin.context.project.controller

import com.hyeran.portfolio.admin.context.project.form.ProjectForm
import com.hyeran.portfolio.admin.context.project.service.AdminProjectService
import com.hyeran.portfolio.admin.data.ApiResponse
import com.hyeran.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/projects")
class AdminProjectApiController(
    private val adminProjectService: AdminProjectService
) {
    // 삽입
    @PostMapping
    fun postProject(@RequestBody @Validated form: ProjectForm): ResponseEntity<Any> {
        adminProjectService.save(form)

        return ApiResponse.successCreate()
    }

    // 수정
    @PutMapping("/{id}")
    fun putProject(@PathVariable id: Long, @RequestBody form: ProjectForm): ResponseEntity<Any> {
        adminProjectService.update(id, form)

        return ApiResponse.successCreate()
    }

    // detail 가지고 있는 애들은 상세 데이터도 가지고 오도록
    @GetMapping("/{id}/details")
    fun getProjectDetails(@PathVariable id: Long): TableDTO {
        return adminProjectService.getProjectDetailTable(id)
    }
}