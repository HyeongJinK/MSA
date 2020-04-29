package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.VcCompanyDTO;
import com.illunex.invest.api.core.investment.dto.ListDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> getAllList();
    CompanyDTO getCompanyById(final Long id);
    Long registerCompany(String businessNumber);
    CompanyDTO updateCompany(CompanyDTO companyDTO);
    List<VcCompanyDTO> getFavoriteCompanyList(ListDTO listDTO);
    List<VcCompanyDTO> getVcCompanyList();
}
