package com.illunex.invest.ir.controller;

import com.illunex.invest.api.core.ir.controller.VCController;
import com.illunex.invest.api.core.ir.dto.*;
import com.illunex.invest.ir.service.VCService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VCControllerImpl implements VCController {
    private Log log = LogFactory.getLog(VCControllerImpl.class);

    final VCService VCService;
    public VCControllerImpl(VCService VCService) {
        this.VCService = VCService;
    }

    @Override
    public ResponseEntity<IRDTO> getIR(Long companyIdx) {
        return new ResponseEntity(VCService.getIR(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BasicInfoDTO> getBasicInfo(Long companyIdx) {
        return new ResponseEntity(VCService.getBasicInfo(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FinanceDTO> getFinanceInfo(Long companyIdx) {
        return new ResponseEntity(VCService.getFinanceInfo(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListDTO> getHistoryList(Long companyIdx) {
        return new ResponseEntity(VCService.getHistoryList(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListDTO> getMemberList(Long companyIdx) {
        return new ResponseEntity(VCService.getMemberList(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<OutcomeDTO> getOutcomeInfo(Long companyIdx) {
        return new ResponseEntity(VCService.getOutcomeInfo(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> getProductInfo(Long companyIdx) {
        return new ResponseEntity(VCService.getProductInfo(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ListDTO> getShareholderList(Long companyIdx) {
        return new ResponseEntity(VCService.getShareholderList(companyIdx), HttpStatus.OK);
    }
}
