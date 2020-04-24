package com.illunex.invest.api.composite.startup.communication.controller;

import com.illunex.invest.api.common.response.ResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/alarm")
public interface AlarmCompositeController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseList> getAlarmList();
}
