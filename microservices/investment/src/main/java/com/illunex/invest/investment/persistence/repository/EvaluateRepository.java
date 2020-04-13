package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluateRepository extends JpaRepository<Evaluate, Long> {
    List<Evaluate> findAllByCompanyIdxAndDeleted(Long companyIdx, Boolean deleted);
    Evaluate findByCompanyIdxAndVcCompanyIdx(Long companyIdx, Long vcCompanyIdx);
}
