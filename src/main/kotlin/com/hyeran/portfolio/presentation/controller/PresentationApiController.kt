package com.hyeran.portfolio.presentation.controller

import com.hyeran.portfolio.presentation.dto.IntroductionDTO
import com.hyeran.portfolio.presentation.dto.LinkDTO
import com.hyeran.portfolio.presentation.dto.ProjectDTO
import com.hyeran.portfolio.presentation.dto.ResumeDTO
import com.hyeran.portfolio.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api") // 하위에 있는 애들한테 전부 /api 경로 앞에 추가해줘
class PresentationApiController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test")
    fun test(): String {
        return "OK" // restcontroller가 그대로 body에 넣어 출력
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> {
        return presentationService.getLinks()
    }

    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> {
        return presentationService.getProjects()
    }

}