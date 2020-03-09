package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.MarketEntity;
import com.illunex.invest.ir.persistence.entity.MarketPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketPlayerRepository extends JpaRepository<MarketPlayerEntity, Long> {
    List<MarketPlayerEntity> deleteAllByProductIdx(Long idx);
}
