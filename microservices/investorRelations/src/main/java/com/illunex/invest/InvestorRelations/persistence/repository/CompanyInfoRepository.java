package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.CompanyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfoEntity, Long> {
}
