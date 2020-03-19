package com.illunex.invest.shop.persistence.entity

import com.illunex.invest.shop.persistence.entity.enumable.ViewMode
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "product")
class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var title: String = ""
    var description: String = ""
    var imgUrl: String= ""
    var price: BigDecimal = BigDecimal.ZERO
    @Enumerated(value = EnumType.STRING)
    var viewMode: ViewMode = ViewMode.OPEN
    @ManyToMany(fetch = FetchType.LAZY)
    var plugins: List<Plugin> = ArrayList()

    constructor()

    constructor(id: Long?) {
        this.id = id
    }

    constructor(id: Long?, title: String, description: String, imgUrl: String, price: BigDecimal, viewMode: ViewMode, plugins: List<Plugin>) {
        this.id = id
        this.title = title
        this.description = description
        this.imgUrl = imgUrl
        this.price = price
        this.viewMode = viewMode
        this.plugins = plugins
    }
}