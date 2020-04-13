package com.illunex.invest.invest.persistence.entity

import javax.persistence.*


@Entity
@Table(name = "evaluate")
data class Evaluate(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var companyIdx: Long? = null,
    var vcCompanyIdx: Long? = null,
    var product: String? = null,
    var company: String? = null,
    var imgUrl: String? = null,
    var updateDate: String? = null,
    var scale: String? = null,
    var status: String? = null,
    var content: String? = null,
    var score: Int? = 0,

    @OneToMany(mappedBy = "evaluate", cascade = [CascadeType.ALL])
    var judgeList: List<EvaluateJudge>?,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY) @JoinColumn(name = "category_idx")
    var category: EvaluateReviewItemCategory?
) {
    constructor() : this(null, null, null, null, null, null, null, null, null, null, null, null, null )
}
