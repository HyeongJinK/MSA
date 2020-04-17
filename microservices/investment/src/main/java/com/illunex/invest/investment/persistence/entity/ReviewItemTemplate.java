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
@Table(name = "review_item_template")
public class ReviewItemTemplate {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    Long companyIdx;
    String title;
    LocalDateTime updateDate;
    Integer point;
    Boolean deleted;
    Boolean weight;

    @OneToMany(mappedBy = "reviewItemTemplate", cascade = CascadeType.ALL)
    List<ReviewItemCategory> reviewItemCategory;
}
