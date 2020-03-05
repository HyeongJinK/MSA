package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.HistoryServiceImpl;
import com.illunex.invest.api.core.InvestorRelations.controller.HistoryController;
import com.illunex.invest.api.core.InvestorRelations.dto.HistoryDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.EditDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryControllerImpl implements HistoryController {
    private Log log = LogFactory.getLog(HistoryControllerImpl.class);

    final HistoryServiceImpl historyServiceImpl;

    public HistoryControllerImpl(HistoryServiceImpl historyServiceImpl) {
        this.historyServiceImpl = historyServiceImpl;
    }

    @CrossOrigin("*")
    @GetMapping("/history")
    @Override
    public ResponseEntity<List<HistoryDTO>> getHistoryList(Long irIdx) {
        List<HistoryDTO> historyDTOS = historyServiceImpl.getList(irIdx);

        if (historyDTOS == null) {
            return new ResponseEntity("history does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(historyDTOS, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/history")
    @Override
    public ResponseEntity<String> editHistoryList(@RequestBody EditDTO editDTO) {
        String result = historyServiceImpl.editList(editDTO.getIrIdx(), editDTO.getHistory());
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
