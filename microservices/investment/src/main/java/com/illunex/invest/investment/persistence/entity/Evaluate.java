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
    LocalDateTime createDate;
    LocalDateTime requestDate;
    LocalDateTime completeDate;
    String scale;
    String status;
    String content;
    Integer score;
    Boolean deleted;

    @OneToMany(mappedBy = "evaluate", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<EvaluateJudge> judgeList;

}
