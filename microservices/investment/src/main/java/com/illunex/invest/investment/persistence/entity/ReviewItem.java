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
@Table(name = "review_item")
public class ReviewItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String content;

    @ManyToOne @JoinColumn(name = "category_idx")
    ReviewItemCategory reviewItemCategory;
}
