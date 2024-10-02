package com.hyeran.portfolio.domain.entity

import jakarta.persistence.*


@Entity
class Httpinterface : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "http_interface_id")
    var id: Long? = null

}