package com.illunex.invest.shop.persistence.entity

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "purchase")
class Purchase {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var userId: Long = 0

    var regDate: LocalDateTime? = null

    var cancel: Boolean = false

    var cancelDate: LocalDateTime? = null

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var purchaseDetails: List<PurchaseDetail> = ArrayList()

    constructor()

    constructor(userId: Long, regDate: LocalDateTime?, cancel: Boolean, purchaseDetails: List<PurchaseDetail>) {
        this.userId = userId
        this.regDate = regDate
        this.cancel = cancel
        this.purchaseDetails = purchaseDetails
    }

    fun cancel() {
        this.cancel = true
        this.cancelDate = LocalDateTime.now()
    }

}