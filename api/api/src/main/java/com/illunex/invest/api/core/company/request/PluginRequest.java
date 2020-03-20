package com.illunex.invest.api.core.company.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PluginRequest {
    Long pluginId;
    LocalDateTime expiryDate;
    Long companyId;
}
