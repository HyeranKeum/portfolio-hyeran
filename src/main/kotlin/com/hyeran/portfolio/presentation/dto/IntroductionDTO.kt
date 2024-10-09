package com.hyeran.portfolio.presentation.dto

import com.hyeran.portfolio.domain.entity.Introduction

class IntroductionDTO(val content: String) {

    constructor(introduction: Introduction) :
            this(
                content = introduction.content
            )
}