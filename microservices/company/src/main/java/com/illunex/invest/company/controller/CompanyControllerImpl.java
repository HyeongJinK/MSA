package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.CompanyController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CompanyControllerImpl implements CompanyController {
    private Log log = LogFactory.getLog(CompanyControllerImpl.class);

    @Override
    public List<CompanyDTO> getList() {
        return null;
    }

    @Override
    public CompanyController getCompany(Long userIdx) {
        return null;
    }

    @Override
    public void insertCompany(CompanyDTO companyDTO) {

    }


}
