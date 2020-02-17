package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.KeywordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<KeywordEntity, Long> {
}
