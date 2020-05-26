package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.CompanyWriteCheckDTO;
import com.illunex.invest.api.core.company.dto.LogoDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> getAllList();
    CompanyDTO getCompanyById(final Long id);
    Long registerCompany(String businessNumber);
    CompanyDTO updateCompany(CompanyDTO companyDTO);
    LogoDTO getLogo(Long companyIdx);
    void updateLogo(Long id, String squareLogo, String rectangleLogo);
    CompanyWriteCheckDTO getCompanyWriteCheck(Long companyIdx);
}
