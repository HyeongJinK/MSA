package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.HistoryEntity;
import com.illunex.invest.ir.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> deleteAllByIrIdx(Long irIdx);
    List<MemberEntity> findAllByIrIdx(Long irIdx);
    List<MemberEntity> findAllByIrIdxAndImgStatus(Long irIdx, String status);
}
