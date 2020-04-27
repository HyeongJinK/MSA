package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.EvaluateJudgeScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateJudgeScoreRepository extends JpaRepository<EvaluateJudgeScore, Long> {
    void deleteAllByJudgeIdx(Long idx);
}
