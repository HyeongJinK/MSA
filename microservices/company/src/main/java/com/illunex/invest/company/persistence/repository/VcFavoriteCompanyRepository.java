package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.VcFavoriteCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VcFavoriteCompanyRepository extends JpaRepository<VcFavoriteCompany, Long>  {
    List<VcFavoriteCompany> findAllByUserIdx(Long userIdx);
    VcFavoriteCompany findByCompanyIdx(Long companyIdx);
}
