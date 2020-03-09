package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.FinancialStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialStatusRepository extends JpaRepository<FinancialStatusEntity, Long> {
    List<FinancialStatusEntity> deleteAllByFinanceIdx(Long idx);
}
