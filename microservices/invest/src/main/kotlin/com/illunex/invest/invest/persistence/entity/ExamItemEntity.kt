package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
class ExamItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var examItemIdx: Long? = null
    @OneToOne
    var examItemTemplate: ExamItemTemplate? = null

}
