package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.BasicInfoService;
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

    final BasicInfoService basicInfoService;

    public BasicInfoControllerImpl(BasicInfoService basicInfoService) {
        this.basicInfoService = basicInfoService;
    }

    @CrossOrigin("*")
    @GetMapping("/basicInfo")
    @Override
    public ResponseEntity<BasicInfoDTO> getBasicInfo(@RequestParam Long irIdx){
        BasicInfoDTO basicInfo = basicInfoService.get(irIdx);

        if (basicInfo == null) {
            return new ResponseEntity("basicInfo does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(basicInfo, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/basicInfo")
    @Override
    public ResponseEntity<BasicInfoDTO> editBasicInfo(BasicInfoDTO basicInfoDTO) {
        BasicInfoDTO basicInfo = basicInfoService.edit(basicInfoDTO);

        if (basicInfo.getName().equals("unavailable")) {
            return new ResponseEntity("Cannot edit BasicInfo. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(basicInfo, HttpStatus.OK);
        }

    }
}
