package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.InvestorRelationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRelationsRepository extends JpaRepository<InvestorRelationsEntity, Long> {
    InvestorRelationsEntity findByAndCompanyIdxAndYear(Long companyIdx, String year);
}
