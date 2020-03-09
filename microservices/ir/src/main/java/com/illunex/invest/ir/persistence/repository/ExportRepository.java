package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.ExportEntity;
import com.illunex.invest.ir.persistence.entity.InvestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportRepository extends JpaRepository<ExportEntity, Long> {
    List<ExportEntity> deleteAllByOutcomeIdx(Long idx);
}
