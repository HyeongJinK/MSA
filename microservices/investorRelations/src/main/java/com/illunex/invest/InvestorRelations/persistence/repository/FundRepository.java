package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.ExportEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.FundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRepository extends JpaRepository<FundEntity, Long> {
    List<FundEntity> deleteAllByOutcomeIdx(Long idx);
}
