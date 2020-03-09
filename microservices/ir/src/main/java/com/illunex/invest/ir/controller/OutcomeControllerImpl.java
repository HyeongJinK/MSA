package com.illunex.invest.ir.controller;

import com.illunex.invest.ir.service.OutcomeServiceImpl;
import com.illunex.invest.api.core.ir.controller.OutcomeController;
import com.illunex.invest.api.core.ir.dto.OutcomeDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OutcomeControllerImpl implements OutcomeController {
    private Log log = LogFactory.getLog(OutcomeControllerImpl.class);

    final OutcomeServiceImpl outcomeServiceImpl;

    public OutcomeControllerImpl(OutcomeServiceImpl outcomeServiceImpl) {
        this.outcomeServiceImpl = outcomeServiceImpl;
    }

    @Override
    public ResponseEntity<OutcomeDTO> getOutcomeInfo(@RequestParam Long irIdx){
        OutcomeDTO outcomeInfo = outcomeServiceImpl.get(irIdx);

        if (outcomeInfo == null) {
            return new ResponseEntity("outcomeInfo does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(outcomeInfo, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> editOutcomeInfo(OutcomeDTO outcomeInfo) {
        String result = outcomeServiceImpl.edit(outcomeInfo);

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
