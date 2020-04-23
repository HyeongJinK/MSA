package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<Business, Long> {
    Business findByCompanyCompanyIdx(Long companyIdx);
}
