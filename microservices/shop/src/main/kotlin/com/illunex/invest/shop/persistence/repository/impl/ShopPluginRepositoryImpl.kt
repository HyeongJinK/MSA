package com.illunex.invest.shop.persistence.repository.impl;

import com.illunex.invest.shop.persistence.entity.QPlugin
import com.illunex.invest.shop.persistence.entity.QPluginRole
import com.illunex.invest.shop.persistence.repository.custom.ShopPluginCustomRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ShopPluginRepositoryImpl: ShopPluginCustomRepository {
    @Autowired
    var queryFactory: JPAQueryFactory? = null

    override fun findRoleByIds(ids:List<Long>) : List<String> {
        var plugin: QPlugin = QPlugin.plugin;
        var pluginRole: QPluginRole = QPluginRole.pluginRole;

        return queryFactory!!.select(pluginRole.roleTitle)
                .from(plugin)
                .leftJoin(plugin.pluginRole, pluginRole)
                .where(plugin.id.`in`(ids))
                .fetch()
    }
}
