package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "review_item")
data class ReviewItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var category: String,
    var title: String,
    var point: Int,
    var content: String,
    var updateDate: String,
    var deleted: Boolean,

    @ManyToOne @JoinColumn(name = "evaluateIdx")
    var evaluate: Evaluate

)
