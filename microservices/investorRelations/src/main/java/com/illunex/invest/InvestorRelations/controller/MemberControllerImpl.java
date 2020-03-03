package com.illunex.invest.InvestorRelations.controller;

import com.illunex.invest.InvestorRelations.service.MemberServiceImpl;
import com.illunex.invest.api.core.InvestorRelations.controller.MemberController;
import com.illunex.invest.api.core.InvestorRelations.dto.MemberDTO;
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

    @CrossOrigin("*")
    @GetMapping("/member")
    @Override
    public ResponseEntity<List<MemberDTO>> getMemberList(Long irIdx) {
        List<MemberDTO> memberDTOS = memberServiceImpl.getList(irIdx);

        if (memberDTOS == null) {
            return new ResponseEntity("member does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(memberDTOS, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/member")
    @Override
    public ResponseEntity<List<MemberDTO>> editMemberList(@RequestBody List<MemberDTO> memberDTOList) {
        List<MemberDTO> memberDTOS = memberServiceImpl.editList(memberDTOList);

        if (memberDTOS.get(0).getName().equals("unavailable")) {
            return new ResponseEntity("Cannot edit member. Invalid IR Index.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(memberDTOS, HttpStatus.OK);
        }
    }
}
