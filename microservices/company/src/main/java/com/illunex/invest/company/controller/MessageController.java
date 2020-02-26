package com.illunex.invest.company.controller;

import com.illunex.invest.company.configuration.ApplicationConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MessageController {
    private final ApplicationConfiguration configuration;

    @RequestMapping("/message")
    public Map<String, String> welcome() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", configuration.getTest());
        return map;
    }
}
