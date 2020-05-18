package com.illunex.invest.shop.service

import com.illunex.invest.api.core.shop.dto.PluginDTO
import com.illunex.invest.shop.persistence.repository.ShopPluginRepository
import com.illunex.invest.shop.service.mapper.PluginMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ShopPluginServiceImpl: ShopPluginService {
    private var pluginMapper: PluginMapper = PluginMapper()
    @Autowired var shopPluginRepository: ShopPluginRepository? = null

    override fun getRoleNamesByPluginId(ids:List<Long>):List<String> {
        return shopPluginRepository!!.findRoleByIds(ids)
    }

    override fun getPluginByPluginIds(ids: List<Long>): List<PluginDTO> {
        return pluginMapper.dtoToEntity(shopPluginRepository!!.findAllById(ids))
    }
}
