package com.illunex.invest.invest.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "evaluate_review_category")
data class EvaluateReviewItemCategory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Long? = null,
    var vcCompanyIdx: Long? = null,
    var category: String? = null,

    @OneToOne(mappedBy = "category", fetch = FetchType.LAZY, cascade = [CascadeType.DETACH])
    var evaluate: Evaluate?,

    @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL])
    var reviewItem: List<EvaluateReviewItem>?
) {
    constructor() : this(null, null, null, null, null )
}
