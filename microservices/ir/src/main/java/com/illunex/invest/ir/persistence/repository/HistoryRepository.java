package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import com.illunex.invest.ir.persistence.entity.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
    List<HistoryEntity> deleteAllByIrIdx(Long irIdx);
    List<HistoryEntity> findAllByIrIdx(Long irIdx);
}
