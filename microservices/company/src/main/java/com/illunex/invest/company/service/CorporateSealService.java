package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CorporateSealDTO;

import java.util.List;

public interface CorporateSealService {
    List<CorporateSealDTO> corporateSeal(Long companyId);
    CorporateSealDTO addCorporateSeal(CorporateSealDTO corporateSealDTO);
    void toggleCorporateSeal(Long id);
    void delCorporateSeal(Long id);

}
