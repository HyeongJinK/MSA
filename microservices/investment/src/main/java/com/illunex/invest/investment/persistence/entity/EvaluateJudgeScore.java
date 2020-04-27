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
@Table(name = "evaluate_judge_score")
public class EvaluateJudgeScore {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long categoryIdx;
    Long reviewItemIdx;
    Integer score;

    @ManyToOne
    @JoinColumn(name = "judge_idx")
    EvaluateJudge judge;

}
