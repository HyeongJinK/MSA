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
@Table(name = "review_item_category")
public class ReviewItemCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idx;
    String category;

    @ManyToOne @JoinColumn(name = "template_idx")
    ReviewItemTemplate reviewItemTemplate;

    @OneToMany(mappedBy = "reviewItemCategory", cascade = CascadeType.ALL)
    List<ReviewItem> reviewItem;
}
