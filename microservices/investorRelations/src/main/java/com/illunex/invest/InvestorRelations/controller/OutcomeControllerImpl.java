package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.OutcomeServiceImpl;
import com.illunex.invest.api.core.InvestorRelations.controller.OutcomeController;
import com.illunex.invest.api.core.InvestorRelations.dto.OutcomeDTO;
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

    @CrossOrigin("*")
    @GetMapping("/outcome")
    @Override
    public ResponseEntity<OutcomeDTO> getOutcomeInfo(@RequestParam Long irIdx){
        OutcomeDTO outcomeInfo = outcomeServiceImpl.get(irIdx);

        if (outcomeInfo == null) {
            return new ResponseEntity("outcomeInfo does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(outcomeInfo, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/outcome")
    @Override
    public ResponseEntity<OutcomeDTO> editOutcomeInfo(OutcomeDTO outcomeInfo) {
        OutcomeDTO outcome = outcomeServiceImpl.edit(outcomeInfo);

        if (outcome.getContent().equals("unavailable")) {
            return new ResponseEntity("Cannot edit outcomeInfo. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(outcome, HttpStatus.OK);
        }

    }
}
