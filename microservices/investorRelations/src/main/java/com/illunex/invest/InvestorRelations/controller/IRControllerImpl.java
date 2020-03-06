package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.IRService;
import com.illunex.invest.api.core.InvestorRelations.controller.IRController;
import com.illunex.invest.api.core.InvestorRelations.dto.IRDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.PasswordDTO;
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
    public ResponseEntity<String> setPassword(@RequestBody PasswordDTO passwordDTO) {
        String result = IRService.setPassword(passwordDTO.getIrIdx(), passwordDTO.getPassword());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/list/pw/reset")
    @Override
    public ResponseEntity<String> resetPassword(@RequestParam Long irIdx) {
        String result = IRService.resetPassword(irIdx);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/list/pw/confirm")
    @Override
    public ResponseEntity<String> confirmPassword(@RequestBody PasswordDTO passwordDTO) {
        String result = IRService.confirmPassword(passwordDTO.getIrIdx(), passwordDTO.getPassword());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/list/pw/change")
    @Override
    public ResponseEntity<String> changePassword(@RequestBody PasswordDTO passwordDTO) {
        String result = IRService.changePassword(passwordDTO.getIrIdx(), passwordDTO.getPassword(), passwordDTO.getNewPassword());

        return new ResponseEntity(result, HttpStatus.OK);
    }

}
