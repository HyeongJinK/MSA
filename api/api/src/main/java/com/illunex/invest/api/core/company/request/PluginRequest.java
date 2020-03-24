package com.illunex.invest.api.core.company.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PluginRequest {
    List<Long> pluginId = new ArrayList<>();
    LocalDateTime expiryDate;
    Long companyId;
}
