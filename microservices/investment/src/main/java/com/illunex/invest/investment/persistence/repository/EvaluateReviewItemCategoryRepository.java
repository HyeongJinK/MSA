package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.EvaluateReviewItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateReviewItemCategoryRepository extends JpaRepository<EvaluateReviewItemCategory, Long> {
    void deleteAllByReviewItemTemplateIdx(Long idx);
}
