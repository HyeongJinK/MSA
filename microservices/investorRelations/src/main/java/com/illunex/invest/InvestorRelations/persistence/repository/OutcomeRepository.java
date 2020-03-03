package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.OutcomeEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutcomeRepository extends JpaRepository<OutcomeEntity, Long> {
    OutcomeEntity findByIrIdx(Long irIdx);
}
