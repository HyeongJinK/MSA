package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.EvaluateReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateReviewItemRepository extends JpaRepository<EvaluateReviewItem, Long> {
    List<EvaluateReviewItem> deleteAllByJudgeIdx(Long idx);
}
