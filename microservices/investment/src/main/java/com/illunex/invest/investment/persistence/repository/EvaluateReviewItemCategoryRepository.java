package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.EvaluateReviewItem;
import com.illunex.invest.investment.persistence.entity.EvaluateReviewItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateReviewItemCategoryRepository extends JpaRepository<EvaluateReviewItemCategory, Long> {
    List<EvaluateReviewItemCategory> deleteAllByJudgeIdx(Long idx);
}
