package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
class ExamItemScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var examItemScoreIdx: Long? = null
    var score: String? = null

    @OneToOne
    var examItemEntity: ExamItemEntity? = null
}
