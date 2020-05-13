package com.illunex.invest.investment.controller;

import com.illunex.invest.api.core.investment.controller.RoundController;
import com.illunex.invest.api.core.investment.dto.VQRoundDTO;
import com.illunex.invest.investment.service.RoundService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoundControllerImpl implements RoundController {
    private Log log = LogFactory.getLog(RoundControllerImpl.class);

    final RoundService roundService;

    public RoundControllerImpl(RoundService roundService) {
        this.roundService = roundService;
    }

    @Override
    public ResponseEntity<String> vqRoundAnswer(VQRoundDTO vqRoundDTO) {
        return new ResponseEntity(roundService.vqRoundAnswer(vqRoundDTO), HttpStatus.OK);
    }
}
