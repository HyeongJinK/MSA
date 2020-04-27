package com.illunex.invest.investment.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "evaluate_review_item_template")
public class EvaluateReviewItemTemplate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String title;
    Boolean weightApply;

    @OneToOne(mappedBy = "template", cascade = CascadeType.DETACH)
    Evaluate evaluate;

    @OneToMany(mappedBy = "reviewItemTemplate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<EvaluateReviewItemCategory> reviewItemCategory;

}
