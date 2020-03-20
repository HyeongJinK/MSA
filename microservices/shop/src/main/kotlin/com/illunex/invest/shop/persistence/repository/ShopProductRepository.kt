package com.illunex.invest.shop.persistence.repository

import com.illunex.invest.api.core.shop.enumable.ViewMode
import com.illunex.invest.shop.persistence.entity.Product
import com.illunex.invest.shop.persistence.repository.custom.ShopProductCustomRepository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopProductRepository: JpaRepository<Product, Long>, ShopProductCustomRepository {
    fun findAllByViewMode(viewMode: ViewMode): List<Product>
}