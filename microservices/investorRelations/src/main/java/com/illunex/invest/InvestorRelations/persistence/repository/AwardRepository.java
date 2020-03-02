package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.AwardEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.InvestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<AwardEntity, Long> {
    List<AwardEntity> deleteAllByOutcomeIdx(Long idx);
}
