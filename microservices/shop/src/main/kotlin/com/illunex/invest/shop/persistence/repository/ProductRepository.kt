package com.illunex.invest.shop.persistence.repository

import com.illunex.invest.shop.persistence.entity.Product
import com.illunex.invest.shop.persistence.entity.enumable.ViewMode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
    fun findByViewMode(viewMode: ViewMode): List<Product>
}