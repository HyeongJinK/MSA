package com.illunex.invest.invest.persistence.repository

import com.illunex.invest.invest.persistence.entity.Judge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JudgeRepository: JpaRepository<Judge, Long> {

}