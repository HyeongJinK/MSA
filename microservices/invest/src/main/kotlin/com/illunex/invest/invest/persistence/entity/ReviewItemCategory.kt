package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "review_category")
data class ReviewItemCategory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var vcCompanyIdx: Long? = null,
    var category: String? = null,

    @OneToMany(mappedBy = "category")
    var item: List<ReviewItem>?

) {
    constructor() : this(null, null, null, null)
}
