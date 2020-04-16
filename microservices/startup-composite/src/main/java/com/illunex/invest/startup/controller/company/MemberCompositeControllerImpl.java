package com.illunex.invest.startup.controller.company;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.company.controller.MemberCompositeController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.MemberDTO;
import com.illunex.invest.startup.service.company.MemberCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberCompositeControllerImpl implements MemberCompositeController {
    private final MemberCompositeIntegration memberCompositeIntegration;

    @Override
    public ResponseEntity<ResponseData> memberList() {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(memberCompositeIntegration.getMembers())
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> editMember(List<MemberDTO> memberDTOS) {
        memberCompositeIntegration.editMember(memberDTOS);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> readMember(Long id) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(memberCompositeIntegration.getMember(id))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> deleteMember(Long id) {
        memberCompositeIntegration.deleteMember(id);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> uploadImage(MultipartFile file) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(memberCompositeIntegration.uploadLogo(file))
                .build());
    }
}
