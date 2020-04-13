package com.illunex.invest.investment.controller;

import com.illunex.invest.api.core.investment.controller.JudgeController;
import com.illunex.invest.api.core.investment.dto.EditDTO;
import com.illunex.invest.api.core.investment.dto.JudgeDTO;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import com.illunex.invest.investment.service.JudgeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JudgeControllerImpl implements JudgeController {
    private Log log = LogFactory.getLog(JudgeControllerImpl.class);

    final JudgeService judgeService;

    public JudgeControllerImpl(JudgeService judgeService) { this.judgeService = judgeService; }

    @Override
    public ResponseEntity<ListDTO> getJudgeList(Long companyIdx) {
        return new ResponseEntity(judgeService.getJudgeList(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<JudgeDTO> getJudge(Long judgeIdx) {
        return new ResponseEntity(judgeService.getJudge(judgeIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> editJudge(EditDTO editDTO){
        return new ResponseEntity(judgeService.editJudge(editDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteJudge(JudgeDTO judgeDTO) {
        return new ResponseEntity(judgeService.deleteJudge(judgeDTO), HttpStatus.OK);
    }

}
