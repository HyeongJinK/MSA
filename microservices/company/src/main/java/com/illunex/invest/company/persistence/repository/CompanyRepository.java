package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.repository.custom.CompanyCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, CompanyCustomRepository  {
    Company findByUserIdx(Long userIdx);
}
