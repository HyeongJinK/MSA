package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.VQRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VQRoundRepository extends JpaRepository<VQRound, Long> {
    VQRound findByCompanyIdx(Long companyIdx);
}
