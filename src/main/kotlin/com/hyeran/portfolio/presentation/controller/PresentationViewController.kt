package com.hyeran.portfolio.presentation.controller

import com.hyeran.portfolio.domain.constant.SkillType
import com.hyeran.portfolio.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller // controller는 기본적으로 html울 반환한다. (controller, service, repository)
class PresentationViewController(
    private val presentationService: PresentationService
) {

    @GetMapping("/test") // http 메서드를 지정 -> 여기서는 get
    fun test(): String {
        return "test"
    }

    @GetMapping("/")
    fun index(model: org.springframework.ui.Model): String {
        val introductions = presentationService.getIntroductions()
        model.addAttribute("introductions", introductions)

        val links = presentationService.getLinks()
        model.addAttribute("links", links)

        return "presentation/index" // html 파일 위치를 반환
    }

    @GetMapping("/resume")
    fun resume(model: org.springframework.ui.Model): String {

        val resume = presentationService.getResume()
        model.addAttribute("resume", resume)
        model.addAttribute("skillTypes", SkillType.values())

        return "presentation/resume"
    }

    @GetMapping("/projects")
    fun projects(model: org.springframework.ui.Model): String {

        val projects = presentationService.getProjects() //proiject DTO가 요소인 리스트의 형태
        model.addAttribute("projects", projects)

        return "presentation/projects"
    }
}