package com.hyeran.portfolio.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller // controller는 기본적으로 html울 반환한다. (controller, service, repository)
class PresentationViewController {

    @GetMapping("/test") // http 메서드를 지정 -> 여기서는 get
    fun test(): String {
        return "test"
    }
}