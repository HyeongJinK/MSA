package com.illunex.invest.shop.persistence.repository.Impl

import com.illunex.invest.api.core.shop.enumable.ViewMode
import com.illunex.invest.shop.persistence.entity.Product
import com.illunex.invest.shop.persistence.entity.QPlugin
import com.illunex.invest.shop.persistence.entity.QProduct
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