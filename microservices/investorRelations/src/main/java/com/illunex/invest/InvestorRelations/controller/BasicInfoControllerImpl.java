package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.BasicInfoInfoServiceImpl;
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

    final BasicInfoInfoServiceImpl basicInfoServiceImpl;

    public BasicInfoControllerImpl(BasicInfoInfoServiceImpl basicInfoServiceImpl) {
        this.basicInfoServiceImpl = basicInfoServiceImpl;
    }

    @CrossOrigin("*")
    @GetMapping("/basicInfo")
    public ResponseEntity<BasicInfoDTO> getBasicInfo(@RequestParam Long irIdx){
        BasicInfoDTO basicInfo = basicInfoServiceImpl.get(irIdx);

        return new ResponseEntity<>(basicInfo, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/basicInfo")
    @Override
    public ResponseEntity<BasicInfoDTO> addBasicInfo(BasicInfoDTO basicInfoDTO) {
        BasicInfoDTO basicInfo = basicInfoServiceImpl.edit(basicInfoDTO);
        return new ResponseEntity<>(basicInfo, HttpStatus.OK);
    }
}
