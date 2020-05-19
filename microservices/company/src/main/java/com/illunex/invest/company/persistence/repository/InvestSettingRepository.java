package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.InvestSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestSettingRepository extends JpaRepository<InvestSetting, Long> {
    InvestSetting findByCompanyCompanyIdx(Long companyIdx);
}
