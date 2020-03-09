package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyProductRepository extends JpaRepository<Product, Long> {
}
