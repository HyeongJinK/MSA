package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "judge")
data class Judge(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var userIdx: Long? = null,
    var name: String? = null,
    var rank: String? = null,
    var imgUrl: String? = null
) {
    constructor() : this(null, null, null, null, null )
}

