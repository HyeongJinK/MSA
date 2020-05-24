package com.illunex.invest.shop.service

import com.illunex.invest.api.core.shop.dto.PluginDTO
import com.illunex.invest.api.core.shop.dto.ProductDTO
import com.illunex.invest.api.core.shop.dto.PurchaseDTO
import com.illunex.invest.api.core.shop.enumable.ViewMode
import com.illunex.invest.api.core.shop.request.BuyProductRequest
import com.illunex.invest.shop.persistence.entity.Plugin
import com.illunex.invest.shop.persistence.entity.Product
import com.illunex.invest.shop.persistence.entity.Purchase
import com.illunex.invest.shop.persistence.entity.PurchaseDetail
import com.illunex.invest.shop.persistence.repository.PurchaseRepository
import com.illunex.invest.shop.persistence.repository.ShopProductRepository
import com.illunex.invest.shop.service.mapper.PluginMapper
import com.illunex.invest.shop.service.mapper.ProductMapper
import com.illunex.invest.shop.service.mapper.PurchaseMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
@Transactional(readOnly = true)
class ShopProductServiceImpl : ShopProductService {
    private var productMapper: ProductMapper = ProductMapper()
    private var purchaseMapper: PurchaseMapper = PurchaseMapper()
    private var pluginMapper: PluginMapper = PluginMapper()
    private var shopProductRepository: ShopProductRepository? = null
    private var purchaseRepository: PurchaseRepository? = null

    constructor(shopProductRepository: ShopProductRepository?, purchaseRepository: PurchaseRepository?) {
        this.shopProductRepository = shopProductRepository
        this.purchaseRepository = purchaseRepository
    }

    override fun getPluginList(): List<ProductDTO>? {
        return productMapper.DtoTOEntity(shopProductRepository!!.findAllByViewModeNot(ViewMode.CLOSE))
    }
    @Transactional
    override fun purchase(userId: Long, buyProducts: List<BuyProductRequest>): PurchaseDTO? {
        var ids:ArrayList<Long> = ArrayList()
        var roleName:ArrayList<String> = ArrayList()
        var saveResult:Purchase = purchaseRepository!!.save(Purchase(userId
                , LocalDateTime.now()
                , false
                , setPurchaseDetails(buyProducts)))

        saveResult.purchaseDetails.stream()
                .forEach {pd ->
                    run {
                        //println(pd.products.id)
                        var product:Product = shopProductRepository!!.findById(pd.products.id!!).get()
                        //println(product.plugins.size)

                        ids.add(pd.products.id!!)
                        product.plugins
                                .stream()
                                .map {
                                    plugin -> plugin.pluginRole
                                        .stream()
                                        .map {
                                            role -> role.roleTitle
                                        }.forEach {
                                            name -> run {
                                                roleName.add(name)
                                            }
                                        }
                                }
                    }
                }
        var purchaseDto:PurchaseDTO = purchaseMapper.DtoTOEntity(saveResult)
        //println(ids)
        purchaseDto.ids = ids
        purchaseDto.roles = roleName
        return purchaseDto
    }

    private fun setPurchaseDetails(buyProducts: List<BuyProductRequest>): ArrayList<PurchaseDetail> {
        var purchaseDetails: ArrayList<PurchaseDetail> = ArrayList()

        for (buyProduct in buyProducts) {
            purchaseDetails.add(PurchaseDetail(Product(buyProduct.productId), buyProduct.count))
        }
        return purchaseDetails
    }


    @Transactional
    override fun cancel(purchaseId: Long) {
        var purchase: Purchase = purchaseRepository!!.findById(purchaseId).orElseThrow()
        purchase.cancel()
    }

    override fun getPluginByPluginIds(ids: List<Long>): List<PluginDTO> {
        var plugins:ArrayList<Plugin> = ArrayList()
        var products:List<Product> = shopProductRepository!!.findAllById(ids)

        products.stream()
                .map {
                    product -> product.plugins
                }
                .forEach {
                    role -> run {
                        plugins.addAll(role)
                    }
                }

        return pluginMapper.dtoToEntity(plugins)
    }
}
