package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.ExportEntity;
import com.illunex.invest.ir.persistence.entity.FundEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRepository extends JpaRepository<FundEntity, Long> {
    List<FundEntity> deleteAllByOutcomeIdx(Long idx);
}
