package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.IREntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRRepository extends JpaRepository<IREntity, Long> {
    IREntity findByCompanyIdxAndYear(Long companyIdx, String year);
    Optional<IREntity> findByBasicInfoIdx(Long idx);
    List<IREntity> findAllByCompanyIdx(Long companyIdx);
}
