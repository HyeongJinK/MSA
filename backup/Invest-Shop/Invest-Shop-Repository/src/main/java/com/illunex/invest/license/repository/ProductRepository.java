package com.illunex.invest.license.repository;

import com.illunex.invest.license.entity.Product;
import com.illunex.invest.license.enumable.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductType(ProductType productType);
}
