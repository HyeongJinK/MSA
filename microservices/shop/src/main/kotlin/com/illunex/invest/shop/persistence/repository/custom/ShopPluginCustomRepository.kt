package com.illunex.invest.shop.persistence.repository.custom;

import com.illunex.invest.shop.persistence.entity.QPlugin
import com.illunex.invest.shop.persistence.entity.QPluginRole
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

interface ShopPluginCustomRepository {
    fun findRoleByIds(ids:List<Long>) : List<String>
}
