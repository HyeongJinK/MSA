package com.illunex.invest.ir.controller;

import com.illunex.invest.ir.service.IRService;
import com.illunex.invest.api.core.ir.controller.IRController;
import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.ir.dto.IRListDTO;
import com.illunex.invest.api.core.ir.dto.PasswordDTO;
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

    @Override
    public ResponseEntity<IRListDTO> getIRList(@RequestParam Long companyIdx){
        IRListDTO ir = IRService.getList(companyIdx);
        return new ResponseEntity<>(ir, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> changeCardColor(@RequestBody IRDTO irdto) {
        String result = IRService.changeCardColor(irdto.getIrIdx(), irdto.getCardColor());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> setPassword(@RequestBody PasswordDTO passwordDTO) {
        String result = IRService.setPassword(passwordDTO.getIrIdx(), passwordDTO.getPassword());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> resetPassword(@RequestBody PasswordDTO passwordDTO) {
        String result = IRService.resetPassword(passwordDTO.getIrIdx());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> confirmPassword(@RequestBody PasswordDTO passwordDTO) {
        String result = IRService.confirmPassword(passwordDTO.getIrIdx(), passwordDTO.getPassword());
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> changePassword(@RequestBody PasswordDTO passwordDTO) {
        String result = IRService.changePassword(passwordDTO.getIrIdx(), passwordDTO.getPassword(), passwordDTO.getNewPassword());
        return new ResponseEntity(result, HttpStatus.OK);
    }

}
