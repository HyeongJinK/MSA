package com.illunex.invest.shop.persistence.repository

import com.illunex.invest.shop.persistence.entity.Plugin
import com.illunex.invest.shop.persistence.repository.custom.ShopPluginCustomRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopPluginRepository: JpaRepository<Plugin, Long>, ShopPluginCustomRepository {

}
