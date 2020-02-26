package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.CompanyController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class CompanyControllerImpl implements CompanyController {
    private Log log = LogFactory.getLog(CompanyControllerImpl.class);

    private final CompanyService companyService;

    @Override
    public ResponseEntity<List<CompanyDTO>> getAllList() {
        return null;
    }

    @Override
    public ResponseEntity<CompanyDTO> getCompany(Long userIdx) {
        log.debug(userIdx);
        return new ResponseEntity<>(companyService.getCompanyByUserIdx(userIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Long> insertCompany(CompanyDTO companyDTO) {
        return null;
    }

    @ExceptionHandler(NoneCompanyException.class)
    public ResponseEntity<HashMap> NoneCompanyException(NoneCompanyException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "None_Company");
        result.put("userIdx", e.getMessage());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
