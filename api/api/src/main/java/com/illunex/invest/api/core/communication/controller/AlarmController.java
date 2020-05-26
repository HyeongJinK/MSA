package com.illunex.invest.api.core.communication.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.communication.model.AddAlarmRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alarm")
public interface AlarmController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseList> getList(@RequestParam("userId") Long userId);
    @PostMapping(value = {"", "/"})
    ResponseEntity<ResponseData> sender(@RequestBody AddAlarmRequest request);
    @PostMapping(value = "/reads")
    ResponseEntity<ResponseData> reads(@RequestParam("userId") Long userId);
}
