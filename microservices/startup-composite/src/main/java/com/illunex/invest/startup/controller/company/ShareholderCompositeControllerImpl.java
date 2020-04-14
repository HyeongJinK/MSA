package com.illunex.invest.startup.controller.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.company.controller.ShareholderCompositeController;
import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.company.ShareholderCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShareholderCompositeControllerImpl extends StartupDefaultController implements ShareholderCompositeController {
    private final ShareholderCompositeIntegration shareholderCompositeIntegration;

    @Override
    public ResponseEntity<ResponseData> editShareholders(ShareholderDTO shareholderDTO) {
        shareholderCompositeIntegration.editShareholder(shareholderDTO);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> getShareholders() {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(shareholderCompositeIntegration.getShareholderDTOs())
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> getShareholder(Long id) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(shareholderCompositeIntegration.getShareholderDTO(id))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> deleteShareholder(Long id) {
        shareholderCompositeIntegration.deleteShareholder(id);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> lockSetting(Long id, Boolean rock) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> setPassword(Long id, String password) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> passwordCheck(Long id, String password) {
        return null;
    }
}
