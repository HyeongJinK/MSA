package com.illunex.invest.api.core.company.dto;

import com.illunex.invest.api.core.company.dto.enumable.PluginState;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PluginDTO {
    Long id;
    Long productId;
    //Long pluginId;
    PluginState state;
}
