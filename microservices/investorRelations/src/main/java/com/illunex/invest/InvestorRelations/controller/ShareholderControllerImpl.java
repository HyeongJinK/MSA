package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.HistoryServiceImpl;
import com.illunex.invest.InvestorRelations.service.ShareholderServiceImpl;
import com.illunex.invest.api.core.InvestorRelations.controller.HistoryController;
import com.illunex.invest.api.core.InvestorRelations.controller.ShareholderController;
import com.illunex.invest.api.core.InvestorRelations.dto.HistoryDTO;
import com.illunex.invest.api.core.InvestorRelations.dto.ShareholderDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShareholderControllerImpl implements ShareholderController {
    private Log log = LogFactory.getLog(ShareholderControllerImpl.class);

    final ShareholderServiceImpl shareholderServiceImpl;

    public ShareholderControllerImpl(ShareholderServiceImpl shareholderServiceImpl) {
        this.shareholderServiceImpl = shareholderServiceImpl;
    }

    @CrossOrigin("*")
    @GetMapping("/shareholder")
    @Override
    public ResponseEntity<List<ShareholderDTO>> getShareholderList(Long irIdx) {
        List<ShareholderDTO> shareholderDTOS = shareholderServiceImpl.getList(irIdx);

        if (shareholderDTOS == null) {
            return new ResponseEntity("shareholder does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(shareholderDTOS, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/shareholder")
    @Override
    public ResponseEntity<List<ShareholderDTO>> editShareholderList(@RequestBody List<ShareholderDTO> shareholderDTOList) {
        List<ShareholderDTO> shareholderDTOS = shareholderServiceImpl.editList(shareholderDTOList);

        if (shareholderDTOS.get(0).getName().equals("unavailable")) {
            return new ResponseEntity("Cannot edit shareholder. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(shareholderDTOS, HttpStatus.OK);
        }
    }
}
