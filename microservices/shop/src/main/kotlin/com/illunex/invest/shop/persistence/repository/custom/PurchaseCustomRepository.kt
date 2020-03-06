package com.illunex.invest.shop.persistence.repository.custom

import com.illunex.invest.shop.persistence.entity.Purchase

interface PurchaseCustomRepository {
    fun findJoinDetailById(id: Long): Purchase?
}