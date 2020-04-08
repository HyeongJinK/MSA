package com.illunex.invest.invest.persistence.entity

import javax.persistence.*


@Entity
@Table(name = "evaluate")
data class Evaluate(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var companyIdx: Long? = null,
    var product: String,
    var company: String,
    var imgUrl: String,
    var updateDate: String,
    var scale: String,
    var status: String,
    var score: Int,

    @OneToMany(mappedBy = "evaluate", cascade = [CascadeType.ALL])
    var judges: List<Judge>,

    @OneToMany(mappedBy = "evaluate", cascade = [CascadeType.ALL])
    var reviewItem: List<ReviewItem>
)
