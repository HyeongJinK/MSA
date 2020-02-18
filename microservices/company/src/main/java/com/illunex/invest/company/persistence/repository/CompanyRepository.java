package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.CompanyEntity;
import com.illunex.invest.company.persistence.repository.custom.CompanyCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>, CompanyCustomRepository  {
    CompanyEntity findByUserIdx(Long userIdx);
}
