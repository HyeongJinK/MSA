package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "review_item")
data class ReviewItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var title: String? = null,
    var point: Int? = 0,
    var content: String? = null,
    var updateDate: String? = null,
    var deleted: Boolean? = false,

    @ManyToOne @JoinColumn(name = "category_idx")
    var category: ReviewItemCategory?

) {
    constructor() : this(null, null, null, null, null, null, null )
}
