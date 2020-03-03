package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.ExportEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.InvestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportRepository extends JpaRepository<ExportEntity, Long> {
    List<ExportEntity> deleteAllByOutcomeIdx(Long idx);
}
