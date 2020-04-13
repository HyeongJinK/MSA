package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.EvaluateJudge;
import com.illunex.invest.investment.persistence.entity.Judge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateJudgeRepository extends JpaRepository<EvaluateJudge, Long> {
    List<EvaluateJudge> deleteAllByEvaluateIdx(Long idx);
}
