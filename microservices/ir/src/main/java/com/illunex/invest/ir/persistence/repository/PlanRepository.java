package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.FundEntity;
import com.illunex.invest.ir.persistence.entity.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
    List<PlanEntity> deleteAllByOutcomeIdx(Long idx);
}
