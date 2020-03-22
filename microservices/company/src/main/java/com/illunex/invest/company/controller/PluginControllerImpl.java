package com.illunex.invest.company.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.core.company.controller.PluginController;
import com.illunex.invest.api.core.company.request.PluginRequest;
import com.illunex.invest.company.service.PluginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PluginControllerImpl implements PluginController {
    private final PluginService pluginService;

    @Override
    public ResponseEntity<ResponseData> savePlugins(PluginRequest request) {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(pluginService.savePlugin(request))
                .build());
    }

    @Override
    public ResponseEntity<ResponseData> togglePlugins(Long id) {
        pluginService.togglePlugin(id);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .build());
    }

    @Override
    public ResponseEntity<ResponseList> getPlugins(Long companyIdx) {
        return ResponseEntity.ok(new ResponseList<>(0
                , "success"
                , pluginService.getPlugins(companyIdx)));
    }
}
