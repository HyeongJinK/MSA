package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.ShareholderController;
import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import com.illunex.invest.company.service.ShareholderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShareholderControllerImpl implements ShareholderController {
    private final ShareholderService shareholderService;

    @Override
    public ResponseEntity<List<ShareholderDTO>> getShareholders(Long companyIdx) {
        return ResponseEntity.ok(shareholderService.findByCompanyIdx(companyIdx));
    }

    @Override
    public ResponseEntity<ShareholderDTO> getShareholder(Long id) {
        return ResponseEntity.ok(shareholderService.findById(id));
    }

    @Override
    public ResponseEntity<String> editShareholder(ShareholderDTO shareholderDTO) {
        shareholderService.edit(shareholderDTO);
        return ResponseEntity.ok("success");
    }

    @Override
    public ResponseEntity<String> deleteShareholder(Long id) {
        shareholderService.delete(id);
        return ResponseEntity.ok("success");
    }
}
