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
@Table(name = "evaluate")
public class Evaluate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long companyIdx;
    Long vcCompanyIdx;
    String product;
    String company;
    String imgUrl;
    LocalDateTime updateDate;
    String scale;
    String status;
    String content;
    Integer score;

    @OneToMany(mappedBy = "evaluate", cascade = CascadeType.ALL)
    List<EvaluateJudge> judgeList;
}
