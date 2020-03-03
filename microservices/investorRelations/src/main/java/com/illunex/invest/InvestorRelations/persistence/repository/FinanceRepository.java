package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.FinanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceRepository extends JpaRepository<FinanceEntity, Long> {
    FinanceEntity findByIrIdx(Long irIdx);
}
