package com.illunex.invest.shop.persistence.repository.impl

import com.illunex.invest.shop.persistence.entity.Purchase
import com.illunex.invest.shop.persistence.entity.QPurchase.purchase
import com.illunex.invest.shop.persistence.entity.QPurchaseDetail
import com.illunex.invest.shop.persistence.repository.custom.PurchaseCustomRepository
import com.querydsl.jpa.impl.JPAQueryFactory

class PurchaseCustomRepositoryImpl: PurchaseCustomRepository {
    private var queryFactory: JPAQueryFactory? = null

    constructor(queryFactory: JPAQueryFactory?) {
        this.queryFactory = queryFactory
    }


    override fun findJoinDetailById(id: Long): Purchase? {
        return queryFactory!!.selectFrom(purchase)
                .join(purchase.purchaseDetails, QPurchaseDetail.purchaseDetail).fetchJoin()
                .where(purchase.id.eq(id))
                .fetchOne()
    }
}