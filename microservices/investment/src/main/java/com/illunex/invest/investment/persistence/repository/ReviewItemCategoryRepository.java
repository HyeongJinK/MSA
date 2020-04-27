package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.ReviewItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewItemCategoryRepository extends JpaRepository<ReviewItemCategory, Long> {
    void deleteAllByReviewItemTemplateIdx(Long templateIdx);
}
