package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.VcCompanyController;
import com.illunex.invest.api.core.company.dto.VcCompanyDetailDTO;
import com.illunex.invest.api.core.company.dto.VcCompanyListDTO;
import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyDTO;
import com.illunex.invest.api.core.company.dto.VcFavoriteCompanyListDTO;
import com.illunex.invest.company.service.VcCompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequiredArgsConstructor
public class VcCompanyControllerImpl implements VcCompanyController {

    private final VcCompanyService vcCompanyService;

    @Override
    public VcCompanyListDTO getVcCompanyList() {
        return VcCompanyListDTO.builder().vcCompanyList(vcCompanyService.getVcCompanyList()).build();
    }

    @Override
    public VcCompanyDetailDTO getVcCompanyDetail(Long companyIdx) {
        return vcCompanyService.getVcCompanyDetail(companyIdx);
    }

    @Override
    public VcFavoriteCompanyListDTO getVcFavoriteCompanyList(Long userIdx) {
        return vcCompanyService.getVcFavoriteCompanyList(userIdx);
    }

    @Override
    public VcFavoriteCompanyDTO getFavoriteCompany(Long companyIdx) {
        return vcCompanyService.getFavoriteCompany(companyIdx);
    }

    @Override
    public String setFavoriteCompany(VcFavoriteCompanyDTO vcFavoriteCompanyDTO) {
        return vcCompanyService.setFavoriteCompany(vcFavoriteCompanyDTO);
    }


}
