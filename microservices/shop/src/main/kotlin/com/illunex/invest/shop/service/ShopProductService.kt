package com.illunex.invest.shop.service

import com.illunex.invest.api.core.shop.dto.ProductDTO
import com.illunex.invest.api.core.shop.dto.PurchaseDTO
import com.illunex.invest.api.core.shop.request.BuyProductRequest

interface ShopProductService {
    // TODO 플러그인 조회
    fun getPluginList(): List<ProductDTO>?

    // 구매(설치)
    fun purchase(userId: Long, buyProduct: List<BuyProductRequest>): PurchaseDTO?

    // 취소
    fun cancel(purchaseId: Long)
}