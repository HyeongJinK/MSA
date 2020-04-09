package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "invest")
data class Invest (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var userIdx: Long? = null,
    var companyIdx: Long? = null,

    @OneToMany(mappedBy = "evaluate", cascade = [CascadeType.ALL])
    var judges: List<Judge>
)


