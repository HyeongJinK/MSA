package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.InvestSettingDTO;

public interface InvestSettingService {
    InvestSettingDTO findByInvestSetting(Long companyIdx);
    void save(InvestSettingDTO investSetting);
}
