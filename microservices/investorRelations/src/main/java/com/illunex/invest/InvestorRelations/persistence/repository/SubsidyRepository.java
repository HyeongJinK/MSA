package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.SubsidyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubsidyRepository extends JpaRepository<SubsidyEntity, Long> {
    List<SubsidyEntity> deleteAllByBasicInfoIdx(Long idx);
}
