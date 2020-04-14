package com.illunex.invest.api.composite.startup.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.company.dto.MemberDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping(value = "/company/member")
public interface MemberCompositeController {
    @GetMapping(value = {"", "/", "/list"})
    ResponseEntity<ResponseData> memberList();
    @PostMapping(value = {"", "/"})
    ResponseEntity<ResponseData> editMember(@RequestBody List<MemberDTO> memberDTO);
    @GetMapping(value = "/{id}")
    ResponseEntity<ResponseData> readMember(@PathVariable Long id);
    @DeleteMapping(value = "/{id}")
    ResponseEntity<ResponseData> deleteMember(@PathVariable Long id);
    @PostMapping(value = {"/image"})
    ResponseEntity<ResponseData> uploadImage(@RequestParam("file") MultipartFile file);
}
