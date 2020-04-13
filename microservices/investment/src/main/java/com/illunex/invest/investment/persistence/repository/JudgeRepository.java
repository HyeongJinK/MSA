package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.Judge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgeRepository extends JpaRepository<Judge, Long> {
}
