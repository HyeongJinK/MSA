package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.AwardEntity;
import com.illunex.invest.ir.persistence.entity.InvestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<AwardEntity, Long> {
    List<AwardEntity> deleteAllByOutcomeIdx(Long idx);
}
