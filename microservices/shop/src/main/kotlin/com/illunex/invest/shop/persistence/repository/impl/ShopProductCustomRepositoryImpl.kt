package com.illunex.invest.shop.persistence.repository.impl

import com.illunex.invest.shop.persistence.repository.custom.ShopProductCustomRepository
import com.querydsl.jpa.impl.JPAQueryFactory

class ShopProductCustomRepositoryImpl: ShopProductCustomRepository {
    private var queryFactory: JPAQueryFactory? = null

    constructor(queryFactory: JPAQueryFactory?) {
        this.queryFactory = queryFactory
    }

//    override fun findPlugins(): Product? {
//        var product:QProduct = QProduct.product;
//        return queryFactory!!.selectFrom(product)
//                .join(product.plugins, QPlugin.plugin)
//                .fetchJoin()
//                .where(product.viewMode.eq(ViewMode.OPEN))
//                .fetchOne()
//    }
}