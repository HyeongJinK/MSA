package com.illunex.invest.shop.persistence.repository

import com.illunex.invest.shop.persistence.entity.PluginInstall
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PluginInstallRepository: JpaRepository<PluginInstall, Long> {
    fun findByUserId(userId: Long)
}