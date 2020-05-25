package com.illunex.invest.shop.controller

import com.illunex.invest.api.common.response.ResponseData
import com.illunex.invest.api.common.response.ResponseList
import com.illunex.invest.api.core.shop.controller.ProductController
import com.illunex.invest.api.core.shop.dto.PluginDTO
import com.illunex.invest.api.core.shop.dto.ProductDTO
import com.illunex.invest.api.core.shop.dto.PurchaseDTO
import com.illunex.invest.api.core.shop.request.PurchaseRequest
import com.illunex.invest.shop.service.ShopProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
class ProductControllerImpl: ProductController {
    @Autowired var shopProductService:ShopProductService? = null

    override fun getPlugins(companyIdx: Long?): ResponseEntity<ResponseList<ProductDTO>> {
        return ResponseEntity.ok(ResponseList(0, "success", shopProductService!!.getPluginList()))
    }

    override fun getPlugins(ids: List<String>): ResponseEntity<ResponseList<PluginDTO>> {
        return ResponseEntity.ok(ResponseList(0, "success",
        shopProductService!!.getPluginByPluginIds(ids.stream().map { s: String -> s.toLong() }.collect(Collectors.toList()))))
    }

    override fun purchase(purchaseRequest: PurchaseRequest?): ResponseEntity<ResponseData<PurchaseDTO>> {
        var purchaseDTO:PurchaseDTO? = shopProductService!!.purchase(purchaseRequest!!.userIdx, purchaseRequest!!.buyProducts)
        return ResponseEntity.ok(ResponseData(0, "success", purchaseDTO!!))
    }
}
/*
return  ResponseEntity.ok(ResponseList(0,
                "success",
                shopPluginService!!
                        .getPluginByPluginIds(ids
                                .stream()
                                .map {
                                    s: String -> s.toLong()
                                }
                                .collect(Collectors.toList())
                        )
        ))
*/