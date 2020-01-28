package com.illunex.invest.investorRelations.repository;

import com.illunex.invest.investorRelations.entity.InvestorRelations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRelatiorRepository extends JpaRepository<InvestorRelations, Long> {
}
