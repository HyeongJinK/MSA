package com.illunex.invest.shop.service

import com.illunex.invest.api.core.shop.dto.ProductDTO
import com.illunex.invest.api.core.shop.model.BuyProduct
import com.illunex.invest.shop.persistence.entity.Purchase

interface ShopService {
    // TODO 플러그인 조회
    fun getPluginListByUserIdx(userId: Long): List<ProductDTO>?

    // 구매(설치)
    fun purchase(userId: Long, buyProduct: List<BuyProduct>): Purchase

    // TODO 활성화&비활성화
    fun toggleActive(pluginInstallId: Long)

    // 취소
    fun cancel(purchaseId: Long)
}