package com.illunex.invest.shop.persistence.entity

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "purchaseDetail")
class PurchaseDetail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.DETACH])
    @JoinColumn(name = "productId")
    var products: Product = Product()

    var count: Int = 0

    constructor()

    constructor(products: Product, count: Int) {
        this.products = products
        this.count = count
    }

    fun getPrice(): BigDecimal {
        return products.price.subtract(BigDecimal(count))
    }
}