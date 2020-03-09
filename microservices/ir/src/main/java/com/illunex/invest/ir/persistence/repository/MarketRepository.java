package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.IPEntity;
import com.illunex.invest.ir.persistence.entity.MarketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<MarketEntity, Long> {
    List<MarketEntity> deleteAllByProductIdx(Long idx);
}
