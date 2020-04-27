package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.EvaluateJudge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluateJudgeRepository extends JpaRepository<EvaluateJudge, Long> {
    void deleteAllByEvaluateIdx(Long idx);
}
