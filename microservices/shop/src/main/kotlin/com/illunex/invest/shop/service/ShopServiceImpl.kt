package com.illunex.invest.shop.service

import com.illunex.invest.api.core.shop.dto.ProductDTO
import com.illunex.invest.api.core.shop.model.BuyProduct
import com.illunex.invest.api.core.shop.model.PurchaseRequest
import com.illunex.invest.shop.persistence.entity.*
import com.illunex.invest.shop.persistence.entity.QProduct.product
import com.illunex.invest.shop.persistence.entity.enumable.ViewMode
import com.illunex.invest.shop.persistence.repository.PluginInstallRepository
import com.illunex.invest.shop.persistence.repository.ProductRepository
import com.illunex.invest.shop.persistence.repository.PurchaseRepository
import com.illunex.invest.shop.service.mapper.ProductMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.ArrayList

@Service
@Transactional(readOnly = true)
class ShopServiceImpl : ShopService {
    private var productMapper: ProductMapper = ProductMapper()
    private var productRepository: ProductRepository? = null
    private var purchaseRepository: PurchaseRepository? = null
    private var pluginInstallRepository: PluginInstallRepository? = null

    constructor(productRepository: ProductRepository?, purchaseRepository: PurchaseRepository?, pluginInstallRepository: PluginInstallRepository) {
        this.productRepository = productRepository
        this.purchaseRepository = purchaseRepository
        this.pluginInstallRepository = pluginInstallRepository
    }

    override fun getPluginListByUserIdx(userId: Long): List<ProductDTO>? {

        pluginInstallRepository?.findByUserId(userId);

        return null//productMapper.productDtoListToEntityList(productList, purchaseList);
    }
    @Transactional
    override fun purchase(userId: Long, buyProducts: List<BuyProduct>): Purchase {
        return purchaseRepository!!.save(Purchase(userId
                , LocalDateTime.now()
                , false
                , setPurchaseDetails(buyProducts, userId)))
    }

    private fun setPurchaseDetails(buyProducts: List<BuyProduct>, userId: Long): ArrayList<PurchaseDetail> {
        var purchaseDetails: ArrayList<PurchaseDetail> = ArrayList()

        for (buyProduct in buyProducts) {
            var product: Product = productRepository!!.findById(buyProduct.productId).orElseThrow()

            savePluginInstall(product, userId)

            purchaseDetails.add(PurchaseDetail(Product(buyProduct.productId), buyProduct.count))
        }
        return purchaseDetails
    }

    private fun savePluginInstall(product: Product, userId: Long) {
        for (plugin: Plugin in product.plugins) {
            pluginInstallRepository!!.save(PluginInstall(userId, true, plugin))
        }
    }

    @Transactional
    override fun toggleActive(pluginInstallId: Long) {
        var pluginInstall: PluginInstall = pluginInstallRepository!!.findById(pluginInstallId).orElseThrow()
        pluginInstall.toggle()
    }

    @Transactional
    override fun cancel(purchaseId: Long) {
        var purchase: Purchase = purchaseRepository!!.findById(purchaseId).orElseThrow()
        purchase.cancel()
    }
}