package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.InvestorRelationsService;
import com.illunex.invest.api.core.InvestorRelations.controller.InvestorRelationsController;
import com.illunex.invest.api.core.InvestorRelations.dto.CompanyInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvestorRelationsControllerImpl implements InvestorRelationsController {
    private Log log = LogFactory.getLog(InvestorRelationsControllerImpl.class);

    final InvestorRelationsService investorRelationsService;

    public InvestorRelationsControllerImpl(InvestorRelationsService investorRelationsService) {
        this.investorRelationsService = investorRelationsService;
    }

    @CrossOrigin("*")
    @GetMapping("/basicInfo")
    public ResponseEntity<CompanyInfoDTO> getBasicInfo(@RequestParam Long companyIdx, @RequestParam String year){
        CompanyInfoDTO basicInfo = investorRelationsService.getBasicInfo(companyIdx, year);

        return new ResponseEntity<>(basicInfo, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/basicInfo")
    @Override
    public ResponseEntity<CompanyInfoDTO> addBasicInfo(BasicInfoDTO basicInfoDTO) {
        CompanyInfoDTO basicInfo = investorRelationsService.editBasicInfo(basicInfoDTO);
        return new ResponseEntity<>(basicInfo, HttpStatus.OK);
    }
}
