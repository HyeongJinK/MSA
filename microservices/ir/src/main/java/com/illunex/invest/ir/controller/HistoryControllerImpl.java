package com.illunex.invest.ir.controller;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.service.HistoryServiceImpl;
import com.illunex.invest.api.core.ir.controller.HistoryController;
import com.illunex.invest.api.core.ir.dto.HistoryDTO;
import com.illunex.invest.api.core.ir.dto.EditDTO;
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

    @Override
    public ResponseEntity<ListDTO> getHistoryList(Long irIdx) {
        ListDTO history = historyServiceImpl.getList(irIdx);

        return new ResponseEntity<>(history, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> editHistoryList(@RequestBody EditDTO editDTO) {
        String result = historyServiceImpl.editList(editDTO.getIrIdx(), editDTO.getHistory());
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
