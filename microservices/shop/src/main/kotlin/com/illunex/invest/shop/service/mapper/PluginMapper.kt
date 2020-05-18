package com.illunex.invest.shop.service.mapper

import com.illunex.invest.api.core.shop.dto.PluginDTO
import com.illunex.invest.api.core.shop.dto.PluginRoleDTO
import com.illunex.invest.shop.persistence.entity.Plugin
import com.illunex.invest.shop.persistence.entity.PluginRole
import java.util.ArrayList

class PluginMapper {
    fun dtoToEntity(plugins: List<Plugin>): List<PluginDTO> {
        var result: ArrayList<PluginDTO> = ArrayList()

        plugins.forEach {item ->
            result.add(dtoToEntity(item))
        }

        return result
    }

    private fun dtoToEntity(plugin: Plugin): PluginDTO {
        return PluginDTO(plugin.id, plugin.title, roleDtoToEntity(plugin.pluginRole))
    }

    private fun roleDtoToEntity(pluginRoles: List<PluginRole>): List<PluginRoleDTO> {
        var pluginRoleDTOs: ArrayList<PluginRoleDTO> = ArrayList()

        pluginRoles.forEach {pr ->
            pluginRoleDTOs.add(roleDtoToEntity(pr))
        }

        return pluginRoleDTOs
    }

    private fun roleDtoToEntity(pluginRole: PluginRole): PluginRoleDTO {
        return PluginRoleDTO(pluginRole.id, pluginRole.roleTitle, pluginRole.menuTitle)
    }
}

