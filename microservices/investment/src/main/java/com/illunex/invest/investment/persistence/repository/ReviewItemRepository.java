package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.ReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewItemRepository extends JpaRepository<ReviewItem, Long> {
    List<ReviewItem> deleteAllByReviewItemCategoryIdx(Long categoryIdx);
}
