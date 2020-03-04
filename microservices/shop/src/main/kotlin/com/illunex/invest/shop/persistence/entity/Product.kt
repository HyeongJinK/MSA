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
    var price: BigDecimal = BigDecimal.ZERO
    @Enumerated(value = EnumType.STRING)
    var viewMode: ViewMode = ViewMode.OPEN
    @ManyToMany(fetch = FetchType.LAZY)
    var plugins: List<Plugin> = ArrayList()

    constructor()

    constructor(id: Long?) {
        this.id = id
    }

    constructor(title: String, description: String, price: BigDecimal, viewMode: ViewMode, plugins: List<Plugin>) {
        this.title = title
        this.description = description
        this.price = price
        this.viewMode = viewMode
        this.plugins = plugins
    }

}