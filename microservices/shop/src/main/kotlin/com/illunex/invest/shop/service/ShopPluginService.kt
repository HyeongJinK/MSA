package com.illunex.invest.shop.service

import com.illunex.invest.api.core.shop.dto.PluginDTO

interface ShopPluginService {
    fun getRoleNamesByPluginId(ids:List<Long>):List<String>
    fun getPluginByPluginIds(ids:List<Long>):List<PluginDTO>
}
