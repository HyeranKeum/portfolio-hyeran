package com.hyeran.portfolio.domain.entity

import jakarta.persistence.*
import jakarta.servlet.http.HttpServletRequest


@Entity
class HttpInterface(httpServletRequest: HttpServletRequest) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

    var cookies: String? = httpServletRequest.cookies
        ?.map{"${it.name}:${it.value}"}
        ?.toString()

    var referer: String? = httpServletRequest.getHeader("referer") // 요청이 어디서 왔는지

    var localAddr: String? = httpServletRequest.localAddr // 클라이언트 ip 주소같은 것들

    var remoteAddr:  String? = httpServletRequest.remoteAddr

    var requestUri: String? = httpServletRequest.requestURI // 어떤 URI로 접속했는지,, root, project, resume 등,

    var userAgent: String? = httpServletRequest.getHeader("user-agent") // 브라우저 정보 사파리 크롬, 모바일, 데스크탑..

}