package com.illunex.invest.api.core.shop.controller;

import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.shop.dto.PluginDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api(value = "플러그인 조회, 설치")
@RequestMapping("/plugin")
public interface PluginController {
    @GetMapping("/roleName")
    ResponseEntity<ResponseList<String>> getRoleNameByIds(@RequestParam("ids") List<String> ids);
    @GetMapping("/plugins")
    ResponseEntity<ResponseList<PluginDTO>> getPlugins(@RequestParam("ids") List<String> ids);
}
