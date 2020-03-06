package com.illunex.invest.shop.persistence.repository

import com.illunex.invest.shop.persistence.entity.Purchase
import com.illunex.invest.shop.persistence.repository.custom.PurchaseCustomRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PurchaseRepository: JpaRepository<Purchase, Long>, PurchaseCustomRepository {
    fun findByUserIdAndCancelFalse(userId: Long): List<Purchase>
}