package com.illunex.invest.company.service.mapper;

import com.illunex.invest.api.core.company.dto.PluginDTO;
import com.illunex.invest.company.persistence.entity.Plugin;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PluginMapper {
    List<PluginDTO> entityToDto(List<Plugin> plugins);
    List<Plugin> dtoToEntity(List<PluginDTO> plugins);
}
