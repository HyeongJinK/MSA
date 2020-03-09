package com.illunex.invest.ir.controller;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.service.MemberServiceImpl;
import com.illunex.invest.api.core.ir.controller.MemberController;
import com.illunex.invest.api.core.ir.dto.EditDTO;
import com.illunex.invest.api.core.ir.dto.MemberDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberControllerImpl implements MemberController {
    private Log log = LogFactory.getLog(MemberControllerImpl.class);

    final MemberServiceImpl memberServiceImpl;

    public MemberControllerImpl(MemberServiceImpl memberServiceImpl) {
        this.memberServiceImpl = memberServiceImpl;
    }

    @Override
    public ResponseEntity<ListDTO> getMemberList(Long irIdx) {
        ListDTO member = memberServiceImpl.getList(irIdx);

        return new ResponseEntity(member, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> editMemberList(@RequestBody EditDTO editDTO) {
        String result = memberServiceImpl.editList(editDTO.getIrIdx(), editDTO.getMember());
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
