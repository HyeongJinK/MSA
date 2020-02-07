package com.illunex.invest.invest.persistence.entity

import com.illunex.invest.invest.persistence.entity.enumable.ViewMode
import javax.persistence.*

@Entity
class ExamMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var examMenuIdx: Long? = null
    var userIdx: Long? = null
    var title: String? = null
    var viewMode: ViewMode? = null

    @OneToMany
    var examItemTemplate: List<ExamItemTemplate>? = null
}
