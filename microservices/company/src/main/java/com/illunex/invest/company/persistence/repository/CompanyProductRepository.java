package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.CompanyProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProductRepository extends JpaRepository<CompanyProduct, Long> {
}
