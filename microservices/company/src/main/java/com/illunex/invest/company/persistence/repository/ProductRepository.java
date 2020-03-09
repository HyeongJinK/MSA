package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.api.core.company.dto.ProductDTO;
import com.illunex.invest.company.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "CompanyProductRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<ProductDTO> findByCompanyCompanyIdx(Long companyIdx, Pageable pageable);
}
