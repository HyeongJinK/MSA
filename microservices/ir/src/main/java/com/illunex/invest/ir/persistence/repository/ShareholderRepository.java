package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.HistoryEntity;
import com.illunex.invest.ir.persistence.entity.ShareholderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareholderRepository extends JpaRepository<ShareholderEntity, Long> {
    List<ShareholderEntity> deleteAllByIrIdx(Long irIdx);
    List<ShareholderEntity> findAllByIrIdx(Long irIdx);
}
