package com.illunex.invest.api.composite.startup.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/menu")
public interface MenuCompositeController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<ResponseData> getMenu();
}
