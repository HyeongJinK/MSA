package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.CorporateSeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorporateSealRepository extends JpaRepository<CorporateSeal, Long> {
    List<CorporateSeal> findAllByCompanyCompanyId(Long companyId);
}
