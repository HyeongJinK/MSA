package com.illunex.invest.shop.service

import com.illunex.invest.shop.persistence.repository.ShopPluginCustomRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ShopPluginServiceImpl: ShopPluginService {
    @Autowired var shopPluginCustomRepository:ShopPluginCustomRepository? = null

    override fun getRoleNamesByPluginId(ids:List<Long>):List<String> {
        return shopPluginCustomRepository!!.findRoleByIds(ids)
    }
}