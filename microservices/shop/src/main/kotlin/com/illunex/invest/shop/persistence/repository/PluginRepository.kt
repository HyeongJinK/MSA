package com.illunex.invest.shop.persistence.repository

import com.illunex.invest.shop.persistence.entity.Plugin
import com.illunex.invest.shop.persistence.repository.custom.PluginCustomRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PluginRepository: JpaRepository<Plugin, Long>, PluginCustomRepository {
}