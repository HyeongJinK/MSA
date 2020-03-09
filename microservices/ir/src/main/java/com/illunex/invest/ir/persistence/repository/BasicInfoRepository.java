package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfoEntity, Long> {
    BasicInfoEntity findByIrIdx(Long irIdx);
}
