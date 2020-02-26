package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.BasicInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfoEntity, Long> {
//    BasicInfoEntity findBy(Long irIdx);
}
