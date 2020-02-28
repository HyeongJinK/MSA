package com.illunex.invest.InvestorRelations.persistence.repository;

import com.illunex.invest.InvestorRelations.persistence.entity.CustomerEntity;
import com.illunex.invest.InvestorRelations.persistence.entity.IPEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPRepository extends JpaRepository<IPEntity, Long> {
    List<IPEntity> deleteAllByProductIdx(Long idx);
}
