package com.illunex.invest.api.core.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.request.PluginRequest;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "회사 API")
@RequestMapping(value = "/plugin")
public interface PluginController {
    @PostMapping({"", "/"})
    ResponseEntity<ResponseData> savePlugins(@RequestBody PluginRequest request);
    @PutMapping("/toggle")
    ResponseEntity<ResponseData> togglePlugins(@RequestParam("id") Long id);
    @GetMapping("/{companyIdx}")
    ResponseEntity<ResponseList> getPlugins(@PathVariable Long companyIdx);


}
