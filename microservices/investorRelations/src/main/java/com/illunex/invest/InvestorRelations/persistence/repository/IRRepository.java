package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRRepository extends JpaRepository<IREntity, Long> {
    IREntity findByCompanyIdxAndYear(Long companyIdx, String year);
    List<IREntity> findAllByCompanyIdx(Long companyIdx);
}
