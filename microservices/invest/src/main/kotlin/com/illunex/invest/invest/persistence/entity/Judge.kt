package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "judge")
data class Judge(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var userIdx: Long? = null,
    var name: String,
    var comment: String,
    var point: Int,
    var rank: String,
    var imgUrl: String,
    var status: String,

    @ManyToOne @JoinColumn(name = "investIdx")
    var invest: Invest,

    @ManyToOne @JoinColumn(name = "evaluateIdx")
    var evaluate: Evaluate
)

