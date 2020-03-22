package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.PluginDTO;
import com.illunex.invest.api.core.company.request.PluginRequest;
import com.illunex.invest.company.persistence.entity.Plugin;
import com.illunex.invest.company.persistence.repository.PluginRepository;
import com.illunex.invest.company.service.mapper.PluginMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PluginServiceImpl implements PluginService {
    private final PluginRepository pluginRepository;

    private PluginMapper mapper = Mappers.getMapper(PluginMapper.class);

    @Override
    public Long savePlugin(PluginRequest request) {
        return pluginRepository.save(Plugin.createPlugin(request)).getId();
    }

    @Override
    public void togglePlugin(Long id) {
        Plugin plugin = pluginRepository.findById(id).orElse(null);

        if (plugin == null) {
            // TODO 예외 처리
        }

        plugin.toggle();
        pluginRepository.save(plugin);
    }

    @Override
    public List<PluginDTO> getPlugins(Long companyIdx) {
        return mapper.entityToDto(pluginRepository.findByCompanyCompanyIdxOrderByPluginIdAsc(companyIdx));
    }
}
