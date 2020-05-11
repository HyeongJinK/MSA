package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.repository.custom.CompanyCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long>, CompanyCustomRepository  {
    List<Company> findByCompanyIdxIn(List<Long> companyIdxList);
}
