package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Shareholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareholderRepository extends JpaRepository<Shareholder, Long> {
    List<Shareholder> findByCompanyCompanyIdx(Long companyIdx);
}
