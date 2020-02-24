package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.InvestorRelationsService;
import com.illunex.invest.api.core.InvestorRelations.controller.InvestorRelationsController;
import com.illunex.invest.api.core.InvestorRelations.dto.CompanyInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.IRBasicInfoDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestorRelationsControllerImpl implements InvestorRelationsController {
    private Log log = LogFactory.getLog(InvestorRelationsControllerImpl.class);

    final InvestorRelationsService investorRelationsService;

    public InvestorRelationsControllerImpl(InvestorRelationsService investorRelationsService) {
        this.investorRelationsService = investorRelationsService;
    }

    @CrossOrigin("*")
    @PostMapping("/basicInfo")
    @Override
    public ResponseEntity<CompanyInfoDTO> addIRBasicInfo(IRBasicInfoDTO irBasicInfoDTO) {
        CompanyInfoDTO basicInfo = investorRelationsService.editIRBasicInfo(irBasicInfoDTO);

        return new ResponseEntity<>(basicInfo, HttpStatus.OK);
    }
}
