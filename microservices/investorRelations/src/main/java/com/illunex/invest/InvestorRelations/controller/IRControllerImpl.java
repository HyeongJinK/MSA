package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.IRService;
import com.illunex.invest.api.core.InvestorRelations.controller.IRController;
import com.illunex.invest.api.core.InvestorRelations.dto.IRDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Override
    public ResponseEntity<List<IRDTO>> getIRList(@RequestParam Long companyIdx){
        List<IRDTO> ir = IRService.getList(companyIdx);
        return new ResponseEntity<>(ir, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/list/color")
    @Override
    public ResponseEntity<IRDTO> changeCardColor(@RequestParam Long irIdx, @RequestParam String color) {
        IRDTO ir = IRService.changeCardColor(irIdx, color);

        if (ir.getCardColor().equals("unavailable")) {
            return new ResponseEntity("Cannot change card color. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(ir, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/list/pw/set")
    @Override
    public ResponseEntity<String> setPassword(@RequestParam Long irIdx, @RequestParam String password) {
        String result = IRService.setPassword(irIdx, password);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/list/pw/confirm")
    @Override
    public ResponseEntity<String> confirmPassword(@RequestParam Long irIdx, @RequestParam String password) {
        String result = IRService.confirmPassword(irIdx, password);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/list/pw/change")
    @Override
    public ResponseEntity<String> changePassword(@RequestParam Long irIdx, @RequestParam String currentPassword, @RequestParam String newPassword) {
        String result = IRService.changePassword(irIdx, currentPassword, newPassword);

        return new ResponseEntity(result, HttpStatus.OK);
    }

}
