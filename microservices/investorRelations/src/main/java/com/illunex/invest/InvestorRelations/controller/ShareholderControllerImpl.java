package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.ShareholderServiceImpl;
import com.illunex.invest.api.core.InvestorRelations.controller.ShareholderController;
import com.illunex.invest.api.core.InvestorRelations.dto.EditDTO;
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
    public ResponseEntity<String> editShareholderList(@RequestBody EditDTO editDTO) {
        String result = shareholderServiceImpl.editList(editDTO.getIrIdx(), editDTO.getShareholder());
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
