package com.illunex.invest.api.core.communication.controller;

import com.illunex.invest.api.common.response.ResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/alarm")
public interface AlarmController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseList> getList(@RequestParam("userId") Long userId);
}
