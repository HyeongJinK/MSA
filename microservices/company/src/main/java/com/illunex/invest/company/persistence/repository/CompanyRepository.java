package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.CompanyEntity;
import com.illunex.invest.company.persistence.repository.custom.CompanyCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>, CompanyCustomRepository  {
    Optional<CompanyEntity> findByUserIdx(Long userIdx);
}
