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
@Table(name = "evaluate_judge")
public class EvaluateJudge {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long userIdx;
    String name;
    String comment;
    String rank;
    String imgUrl;
    String status;

    @ManyToOne @JoinColumn(name = "evaluate_idx")
    Evaluate evaluate;

    @OneToMany(mappedBy = "judge", cascade = CascadeType.ALL)
    List<EvaluateReviewItem> reviewItem;
}
