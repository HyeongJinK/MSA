package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.PluginDTO;
import com.illunex.invest.api.core.company.request.PluginRequest;
import com.illunex.invest.company.persistence.entity.Plugin;
import com.illunex.invest.company.persistence.repository.PluginRepository;
import com.illunex.invest.company.service.mapper.PluginMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PluginServiceImpl implements PluginService {
    private final PluginRepository pluginRepository;

    private PluginMapper mapper = Mappers.getMapper(PluginMapper.class);

    @Override
    @Transactional
    public List<Long> savePlugin(PluginRequest request) {
        List<Long> result = new ArrayList<>();
        request.getPluginId().stream()
                .forEach(id -> {
                    result.add(pluginRepository.save(Plugin.createPlugin(request, id)).getId());
                });
        return result;
    }

    @Override
    @Transactional
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
