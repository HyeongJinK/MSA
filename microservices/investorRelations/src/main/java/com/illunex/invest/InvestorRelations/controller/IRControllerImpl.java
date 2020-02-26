package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.IRService;
import com.illunex.invest.api.core.InvestorRelations.controller.IRController;
import com.illunex.invest.api.core.InvestorRelations.dto.IRDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IRControllerImpl implements IRController {
    private Log log = LogFactory.getLog(IRControllerImpl.class);

    final IRService IRService;

    public IRControllerImpl(IRService IRService) {
        this.IRService = IRService;
    }

    @CrossOrigin("*")
    @GetMapping("/list")
    public ResponseEntity<List<IRDTO>> getIRList(@RequestParam Long companyIdx){
        List<IRDTO> ir = IRService.getList(companyIdx);
        return new ResponseEntity<>(ir, HttpStatus.OK);
    };
}
