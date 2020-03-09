package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    List<CustomerEntity> deleteAllByProductIdx(Long idx);
}
