package com.illunex.invest.ir.controller;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.service.ShareholderServiceImpl;
import com.illunex.invest.api.core.ir.controller.ShareholderController;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.api.core.ir.dto.ShareholderDTO;
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

    @Override
    public ResponseEntity<ListDTO> getShareholderList(Long irIdx) {
        ListDTO shareholder = shareholderServiceImpl.getList(irIdx);

        return new ResponseEntity(shareholder, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> editShareholderList(@RequestBody EditDTO editDTO) {
        String result = shareholderServiceImpl.editList(editDTO.getIrIdx(), editDTO.getShareholder());
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
