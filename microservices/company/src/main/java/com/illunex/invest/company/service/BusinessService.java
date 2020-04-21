package com.illunex.invest.company.service;


import com.illunex.invest.api.core.company.dto.BusinessDTO;

public interface BusinessService {
    BusinessDTO getBusiness(Long companyId);
    BusinessDTO editBusiness(BusinessDTO businessDTO);
}
