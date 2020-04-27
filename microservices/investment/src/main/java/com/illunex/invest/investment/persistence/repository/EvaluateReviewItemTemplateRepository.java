package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.EvaluateReviewItemTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateReviewItemTemplateRepository extends JpaRepository<EvaluateReviewItemTemplate, Long> {
//    void deleteByIdx(Long idx);
    void deleteByEvaluateIdx(Long idx);
}
