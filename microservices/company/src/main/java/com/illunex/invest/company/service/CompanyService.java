package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;

public interface CompanyService {
    CompanyDTO getCompanyByUserIdx(final Long userIdx);
    Long registerCompany(Long userIdx, String businessNumber);
}
