package com.illunex.invest.ir.controller;

import com.illunex.invest.ir.service.FinanceServiceImpl;
import com.illunex.invest.api.core.ir.controller.FinanceController;
import com.illunex.invest.api.core.ir.dto.FinanceDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FinanceControllerImpl implements FinanceController {
    private Log log = LogFactory.getLog(FinanceControllerImpl.class);

    final FinanceServiceImpl financeServiceImpl;

    public FinanceControllerImpl(FinanceServiceImpl financeServiceImpl) {
        this.financeServiceImpl = financeServiceImpl;
    }

    @CrossOrigin("*")
    @GetMapping("/finance")
    @Override
    public ResponseEntity<FinanceDTO> getFinanceInfo(@RequestParam Long irIdx){
        FinanceDTO financeDTO = financeServiceImpl.get(irIdx);

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
        FinanceDTO finance = financeServiceImpl.edit(financeDTO);

        if (finance.getTax().equals("unavailable")) {
            return new ResponseEntity("Cannot edit financeInfo. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(finance, HttpStatus.OK);
        }

    }
}
