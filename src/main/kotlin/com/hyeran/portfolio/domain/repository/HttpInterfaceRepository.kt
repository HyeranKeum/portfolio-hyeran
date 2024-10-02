package com.hyeran.portfolio.domain.repository

import com.hyeran.portfolio.domain.entity.Httpinterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository : JpaRepository<Httpinterface, Long>