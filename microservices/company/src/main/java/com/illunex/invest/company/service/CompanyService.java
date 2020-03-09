package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;

public interface CompanyService {
    CompanyDTO getCompanyById(final Long id);
    Long registerCompany(String businessNumber);
    CompanyDTO updateCompany(CompanyDTO companyDTO);
}
