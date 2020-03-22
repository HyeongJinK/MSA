package com.illunex.invest.shop.service

interface ShopPluginService {
    fun getRoleNamesByPluginId(ids:List<Long>):List<String>
}