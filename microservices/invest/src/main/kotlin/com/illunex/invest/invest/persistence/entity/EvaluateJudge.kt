package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "evaluate_judge")
data class EvaluateJudge(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var userIdx: Long? = null,
    var name: String? = null,
    var comment: String? = null,
    var point: Int? = 0,
    var rank: String? = null,
    var imgUrl: String? = null,
    var status: String? = null,

    @ManyToOne @JoinColumn(name = "evaluate_idx")
    var evaluate: Evaluate?
) {
    constructor() : this(null, null, null, null, null, null, null, null, null )
}

