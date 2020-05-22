package com.illunex.invest.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.controller.CorporateSealController;
import com.illunex.invest.api.core.company.dto.CorporateSealDTO;
import com.illunex.invest.api.core.user.dto.SignatureDTO;
import com.illunex.invest.company.service.CorporateSealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CorporateSealControllerImpl implements CorporateSealController {
    private final CorporateSealService corporateSealService;

    @Override
    public ResponseEntity<ResponseList> corporateSealList(Long companyId) {
        ResponseList<SignatureDTO> data = new ResponseList(0
                , "Success"
                , corporateSealService.corporateSeal(companyId));
        return ResponseEntity.ok(data);
    }

    @Override
    public ResponseEntity<ResponseData> addCorporateSealList(CorporateSealDTO corporateSealDTO) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(corporateSealService.addCorporateSeal(corporateSealDTO))
                .message("Success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> toggleCorporateSeal(Long id) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(corporateSealService.toggleCorporateSeal(id))
                .message("Success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> deleteCorporateSeal(Long id) {
        corporateSealService.delCorporateSeal(id);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("Success")
                .build());
    }
}
