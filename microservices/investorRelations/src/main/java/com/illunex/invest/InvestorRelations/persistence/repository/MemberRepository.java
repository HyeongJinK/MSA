package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.HistoryEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> deleteAllByIrIdx(Long irIdx);
    List<MemberEntity> findAllByIrIdx(Long irIdx);
}
