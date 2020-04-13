package com.illunex.invest.investment.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    String category;
    String content;
    Integer point;
    LocalDateTime updateDate;

    @ManyToOne @JoinColumn(name = "judge_idx")
    EvaluateJudge judge;
       
}
