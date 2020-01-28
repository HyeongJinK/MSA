package com.illunex.invest.invest.repository;

import com.illunex.invest.invest.entity.Invest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestRepository extends JpaRepository<Invest, Long> {
}
