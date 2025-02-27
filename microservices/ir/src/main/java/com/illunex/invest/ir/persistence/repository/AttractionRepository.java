package com.illunex.invest.ir.persistence.repository;

import com.illunex.invest.ir.persistence.entity.AttractionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttractionRepository extends JpaRepository<AttractionEntity, Long> {
    List<AttractionEntity> deleteAllByBasicInfoIdx(Long idx);
}
