package com.illunex.invest.ir.controller;

import com.illunex.invest.api.core.communication.dto.MultiFileDeleteDTO;
import com.illunex.invest.api.core.ir.controller.ImgUploadController;
import com.illunex.invest.api.core.ir.dto.ImgDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.service.HistoryServiceImpl;
import com.illunex.invest.api.core.ir.controller.HistoryController;
import com.illunex.invest.api.core.ir.dto.HistoryDTO;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.ir.service.ImgUploadServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ImgUploadControllerImpl implements ImgUploadController {
    private Log log = LogFactory.getLog(HistoryControllerImpl.class);

    final ImgUploadServiceImpl imgUploadServiceImpl;

    public ImgUploadControllerImpl(ImgUploadServiceImpl imgUploadServiceImpl) {
        this.imgUploadServiceImpl = imgUploadServiceImpl;
    }


    @Override
    public ResponseEntity<String> imgTemp(ImgDTO imgDTO) {
        imgUploadServiceImpl.imgTemp(imgDTO);
        return new ResponseEntity<>("Temp img generated", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MultiFileDeleteDTO> imgDelete(ImgDTO imgDTO) {
        return new ResponseEntity<>(imgUploadServiceImpl.imgDelete(imgDTO.getIrIdx()), HttpStatus.OK);
    }
}
