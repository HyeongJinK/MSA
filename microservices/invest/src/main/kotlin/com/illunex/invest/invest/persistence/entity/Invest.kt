package com.illunex.invest.invest.persistence.entity

import com.illunex.invest.invest.persistence.entity.enumable.InvestState
import javax.persistence.*

@Entity
class Invest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null
    var userIdx: Long? = null
    var companyIdx: Long? = null
    var investState: InvestState? = null

    @OneToMany
    var judges: List<Judge>? = null // 심사위원

    @OneToMany
    var examItemEntities: List<ExamItemEntity>? = null // 심사항목
}
