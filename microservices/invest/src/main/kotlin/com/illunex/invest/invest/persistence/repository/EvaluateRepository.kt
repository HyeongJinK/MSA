package com.illunex.invest.invest.persistence.repository

import com.illunex.invest.invest.persistence.entity.Evaluate
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EvaluateRepository: JpaRepository<Evaluate, Long> {
    fun findAllByCompanyIdx(companyIdx: Long): List<Evaluate>
}