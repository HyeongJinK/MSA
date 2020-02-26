package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.BasicInfoServiceImpl;
import com.illunex.invest.api.core.InvestorRelations.controller.BasicInfoController;
import com.illunex.invest.api.core.InvestorRelations.dto.BasicInfoDTO;
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

    @CrossOrigin("*")
    @GetMapping("/basicInfo")
    public ResponseEntity<BasicInfoDTO> getBasicInfo(@RequestParam Long irIdx){
        BasicInfoDTO basicInfo = basicInfoServiceImpl.get(irIdx);

        if (basicInfo == null) {
            return new ResponseEntity("basicInfo does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(basicInfo, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/basicInfo")
    @Override
    public ResponseEntity<BasicInfoDTO> addBasicInfo(BasicInfoDTO basicInfoDTO) {
        BasicInfoDTO basicInfo = basicInfoServiceImpl.edit(basicInfoDTO);

        if (basicInfo.getName().equals("unavailable")) {
            return new ResponseEntity("Cannot edit BasicInfo. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(basicInfo, HttpStatus.OK);
        }

    }
}
