package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
class Judge {   // 특정 제안에 선택된 심사위원
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var judgeIdx: Long? = null
    var userIdx: Long? = null

    @OneToOne
    var judgeTemplateEntity: JudgeTemplateEntity? = null
    @OneToMany
    var examItemScores: List<ExamItemScore>? = null
}
