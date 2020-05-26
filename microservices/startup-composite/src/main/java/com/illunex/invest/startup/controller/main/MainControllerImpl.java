package com.illunex.invest.startup.controller.main;

import com.illunex.invest.api.core.main.MainController;
import com.illunex.invest.api.core.main.dto.WriteCheckDTO;
import com.illunex.invest.startup.service.main.MainCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainControllerImpl implements MainController {
    Logger logger = LoggerFactory.getLogger(MainControllerImpl.class);

    private final MainCompositeIntegration mainCompositeIntegration;

    @Override
    public ResponseEntity<WriteCheckDTO> getWriteCheck() {
        return new ResponseEntity(mainCompositeIntegration.getWriteCheck(), HttpStatus.OK);
    }
}