package com.illunex.invest.company.repository;

import com.illunex.invest.company.entity.CompanyProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyProductRepository extends JpaRepository<CompanyProduct, Long> {
}
