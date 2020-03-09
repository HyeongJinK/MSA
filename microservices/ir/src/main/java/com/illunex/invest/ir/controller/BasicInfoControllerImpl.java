package com.illunex.invest.ir.controller;

import com.illunex.invest.ir.service.BasicInfoServiceImpl;
import com.illunex.invest.api.core.ir.controller.BasicInfoController;
import com.illunex.invest.api.core.ir.dto.BasicInfoDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicInfoControllerImpl implements BasicInfoController {
    private Log log = LogFactory.getLog(BasicInfoControllerImpl.class);

    final BasicInfoServiceImpl basicInfoServiceImpl;

    public BasicInfoControllerImpl(BasicInfoServiceImpl basicInfoServiceImpl) {
        this.basicInfoServiceImpl = basicInfoServiceImpl;
    }

    @Override
    public ResponseEntity<BasicInfoDTO> getBasicInfo(@RequestParam Long irIdx){
        BasicInfoDTO basicInfo = basicInfoServiceImpl.get(irIdx);

        return new ResponseEntity(basicInfo, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> editBasicInfo(BasicInfoDTO basicInfoDTO) {
        String result = basicInfoServiceImpl.edit(basicInfoDTO);

        return new ResponseEntity(result, HttpStatus.OK);
    }
}
