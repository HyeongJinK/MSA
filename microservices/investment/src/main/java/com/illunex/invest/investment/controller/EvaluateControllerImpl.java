package com.illunex.invest.investment.controller;

import com.illunex.invest.api.core.investment.controller.EvaluateController;
import com.illunex.invest.api.core.investment.dto.EvaluateDTO;
import com.illunex.invest.api.core.investment.dto.EvaluateListDTO;
import com.illunex.invest.investment.service.EvaluateService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvaluateControllerImpl implements EvaluateController {
    private Log log = LogFactory.getLog(EvaluateControllerImpl.class);

    final EvaluateService evaluateService;

    public EvaluateControllerImpl(EvaluateService evaluateService) {
        this.evaluateService = evaluateService;
    }

    @Override
    public ResponseEntity<String> setEvaluate(Long companyIdx, Long vcCompanyIdx) {
        return new ResponseEntity(evaluateService.setEvaluate(companyIdx, vcCompanyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EvaluateListDTO> getEvaluateList(Long companyIdx) {
        return new ResponseEntity(evaluateService.getEvaluateList(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EvaluateDTO> getEvaluate(Long evaluateIdx) {
        return new ResponseEntity(evaluateService.getEvaluate(evaluateIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> editEvaluate(EvaluateDTO evaluateDTO){
        return new ResponseEntity(evaluateService.editEvaluate(evaluateDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteEvaluate(EvaluateDTO evaluateDTO) {
        return new ResponseEntity(evaluateService.deleteEvaluate(evaluateDTO), HttpStatus.OK);
    }

}
