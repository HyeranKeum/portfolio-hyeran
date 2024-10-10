package com.hyeran.portfolio.presentation.intercepter

import com.hyeran.portfolio.domain.entity.HttpInterface
import com.hyeran.portfolio.domain.repository.HttpInterfaceRepository
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor

@Component
class PresentationInterceptor(
    private val httpInterfaceRepository: HttpInterfaceRepository
) : HandlerInterceptor {

    override fun afterCompletion(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any,
        ex: Exception?
    ) {
        val httpInterface = HttpInterface(request)
        httpInterfaceRepository.save(httpInterface)
    }
}