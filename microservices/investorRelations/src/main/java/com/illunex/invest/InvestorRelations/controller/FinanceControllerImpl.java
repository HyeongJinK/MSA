package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.BasicInfoService;
import com.illunex.invest.InvestorRelations.service.FinanceService;
import com.illunex.invest.api.core.InvestorRelations.controller.BasicInfoController;
import com.illunex.invest.api.core.InvestorRelations.controller.FinanceController;
import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.FinanceDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FinanceControllerImpl implements FinanceController {
    private Log log = LogFactory.getLog(FinanceControllerImpl.class);

    final FinanceService financeService;

    public FinanceControllerImpl(FinanceService financeService) {
        this.financeService = financeService;
    }

    @CrossOrigin("*")
    @GetMapping("/finance")
    @Override
    public ResponseEntity<FinanceDTO> getFinanceInfo(@RequestParam Long irIdx){
        FinanceDTO financeDTO = financeService.get(irIdx);

        if (financeDTO == null) {
            return new ResponseEntity("financeInfo does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(financeDTO, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/finance")
    @Override
    public ResponseEntity<FinanceDTO> editFinanceInfo(FinanceDTO financeDTO) {
        FinanceDTO finance = financeService.edit(financeDTO);

        if (finance.getTax().equals("unavailable")) {
            return new ResponseEntity("Cannot edit financeInfo. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(finance, HttpStatus.OK);
        }

    }
}
