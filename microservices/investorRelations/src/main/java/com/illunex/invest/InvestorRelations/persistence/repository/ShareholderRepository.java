package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.HistoryEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.ShareholderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShareholderRepository extends JpaRepository<ShareholderEntity, Long> {
    List<ShareholderEntity> deleteAllByIrIdx(Long irIdx);
    List<ShareholderEntity> findAllByIrIdx(Long irIdx);
}
