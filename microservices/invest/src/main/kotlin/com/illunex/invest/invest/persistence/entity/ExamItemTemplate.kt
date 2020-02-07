package com.illunex.invest.invest.persistence.entity

import com.illunex.invest.invest.persistence.entity.enumable.ViewMode
import javax.persistence.*

@Entity
public class ExamItemTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var examItemTemplateIdx: Long? = null
    var title: String? = null
    var viewMode: ViewMode? = null

    @ManyToOne
    var examMenu: ExamMenu? = null
}
