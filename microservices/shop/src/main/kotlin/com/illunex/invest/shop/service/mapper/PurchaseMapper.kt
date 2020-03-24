package com.illunex.invest.shop.service.mapper;

import com.illunex.invest.api.core.shop.dto.PurchaseDTO;
import com.illunex.invest.shop.persistence.entity.Purchase;

class PurchaseMapper {
    fun DtoTOEntity(purchase: Purchase): PurchaseDTO {
        var purchaseDTO: PurchaseDTO = PurchaseDTO(purchase.id)

        return purchaseDTO
    }
}
