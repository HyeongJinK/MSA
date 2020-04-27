package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.FavoriteCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteCompanyRepository extends JpaRepository<FavoriteCompany, Long> {
    List<FavoriteCompany> findAllByUserIdx(Long userIdx);
    FavoriteCompany findByCompanyIdx(Long companyIdx);
}
