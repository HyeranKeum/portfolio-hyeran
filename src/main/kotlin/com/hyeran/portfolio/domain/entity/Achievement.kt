package com.hyeran.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate


@Entity
class Achievement(
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    var id: Long? = null

    var title: String = title

    var achievedDate: LocalDate? = achievedDate

    var host: String = host

    var isActive: Boolean = isActive


}