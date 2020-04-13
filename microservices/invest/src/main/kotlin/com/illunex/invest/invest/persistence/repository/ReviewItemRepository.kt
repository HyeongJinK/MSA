package com.illunex.invest.invest.persistence.repository

import com.illunex.invest.invest.persistence.entity.ReviewItem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ReviewItemRepository: JpaRepository<ReviewItem, Long> {

}