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
@Table(name = "evaluate_review_item_category")
public class EvaluateReviewItemCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String category;
    Integer weight;

    @ManyToOne
    @JoinColumn(name = "template_idx")
    EvaluateReviewItemTemplate reviewItemTemplate;

    @OneToMany(mappedBy = "reviewItemCategory", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<EvaluateReviewItem> reviewItem;
}
