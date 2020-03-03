package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByIrIdx(Long irIdx);
}
