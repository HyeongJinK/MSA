package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.PluginDTO;
import com.illunex.invest.api.core.company.request.PluginRequest;

import java.util.List;

public interface PluginService {
    List<Long> savePlugin(PluginRequest request);
    void togglePlugin(Long id);
    List<PluginDTO> getPlugins(Long companyIdx);
}
