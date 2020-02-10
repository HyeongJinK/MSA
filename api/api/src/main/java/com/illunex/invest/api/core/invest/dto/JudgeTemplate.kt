package com.illunex.invest.api.core.invest.dto

import java.util.*

class JudgeTemplate {
    var judgeTemplateIdx: Long? = null
    var userIdx: Long? = null
    var accept: Boolean? = null             // 승인여부
    var inviteDate: Date? = null            // 초대
    var createDate: Date? = null            // 가입일
}
