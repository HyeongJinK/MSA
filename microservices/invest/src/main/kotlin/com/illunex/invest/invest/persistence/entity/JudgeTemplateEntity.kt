package com.illunex.invest.invest.persistence.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class JudgeTemplateEntity {// 심사위원
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var judgeTemplateIdx: Long? = null
    var userIdx: Long? = null
    var accept: Boolean? = null             // 승인여부
    var inviteDate: Date? = null            // 초대
    var createDate: Date? = null            // 가입일
}
