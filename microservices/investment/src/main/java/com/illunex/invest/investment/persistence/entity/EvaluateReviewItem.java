package com.illunex.invest.investment.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "evaluate_review_item")
public class EvaluateReviewItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String content;
    Integer point;

    @ManyToOne @JoinColumn(name = "category_idx")
    EvaluateReviewItemCategory reviewItemCategory;
}
