package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.InvestEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestRepository extends JpaRepository<InvestEntity, Long> {
    List<InvestEntity> deleteAllByOutcomeIdx(Long idx);
}
