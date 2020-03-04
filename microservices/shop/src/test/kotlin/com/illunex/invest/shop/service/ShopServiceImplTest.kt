package com.illunex.invest.shop.service

import com.illunex.invest.api.core.shop.model.BuyProduct
import com.illunex.invest.shop.persistence.entity.Plugin
import com.illunex.invest.shop.persistence.entity.Product
import com.illunex.invest.shop.persistence.entity.Purchase
import com.illunex.invest.shop.persistence.entity.PurchaseDetail
import com.illunex.invest.shop.persistence.entity.enumable.PluginState
import com.illunex.invest.shop.persistence.entity.enumable.ViewMode
import com.illunex.invest.shop.persistence.repository.PluginRepository
import com.illunex.invest.shop.persistence.repository.ProductRepository
import com.illunex.invest.shop.persistence.repository.PurchaseRepository
import com.netflix.discovery.converters.Auto
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT
        , properties = ["eureka.client.enabled=false"
    , "spring.cloud.config.enabled=false"
    , "spring.datasource.url=jdbc:h2:mem:shop"])
@Transactional
class ShopServiceImplTest {
    @Autowired
    var pluginRepository: PluginRepository? = null
    @Autowired
    var productRepository: ProductRepository? = null
    @Autowired
    var purchaseRepository: PurchaseRepository? = null
    @Autowired
    var shopService: ShopService? = null

    @Test
    fun purchase() {
        var plugins: ArrayList<Plugin> = ArrayList()
        plugins.add(Plugin("test", PluginState.OPEN))
        pluginRepository!!.saveAll(plugins)
        var product: Product = productRepository!!.save(Product("title", "description", BigDecimal(100), ViewMode.OPEN, plugins))

        var buyProducts: ArrayList<BuyProduct> = ArrayList()
        buyProducts.add(BuyProduct(product.id, 4))

        var purchase: Purchase = shopService!!.purchase(1L, buyProducts)
        var purchase2: Purchase = purchaseRepository!!.findJoinDetailById(purchase.id!!)!!
        var purchaseDetails: List<PurchaseDetail> = purchase2.purchaseDetails
        var p: PurchaseDetail = purchaseDetails.get(0)
        Assert.assertEquals("", purchase.purchaseDetails.get(0).count, p.count)
        //
    }
}