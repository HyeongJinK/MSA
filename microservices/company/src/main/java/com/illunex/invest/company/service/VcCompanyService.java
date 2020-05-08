package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.VcCompanyDTO;
import com.illunex.invest.api.core.company.dto.VcCompanyDetailDTO;
import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyDTO;
import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyListDTO;

import java.util.List;

public interface VcCompanyService {
    List<VcCompanyDTO> getVcCompanyList();
    VcCompanyDetailDTO getVcCompanyDetail(Long companyIdx);
    VcFavoriteCompanyListDTO getVcFavoriteCompanyList(Long userIdx);
    VcFavoriteCompanyDTO getFavoriteCompany(Long companyIdx);
    String setFavoriteCompany(VcFavoriteCompanyDTO vcFavoriteCompanyDTO);
}
