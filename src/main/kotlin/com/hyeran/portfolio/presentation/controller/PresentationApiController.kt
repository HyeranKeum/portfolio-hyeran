package com.hyeran.portfolio.presentation.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api") // 하위에 있는 애들한테 전부 /api 경로 앞에 추가해줘
class PresentationApiController {

    @GetMapping("/test")
    fun test(): String {
        return "OK" // restcontroller가 그대로 body에 넣어 출력
    }
}