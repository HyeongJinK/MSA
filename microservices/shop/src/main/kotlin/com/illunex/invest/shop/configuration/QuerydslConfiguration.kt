package com.illunex.invest.shop.configuration

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Configuration
class QuerydslConfiguration {
    @PersistenceContext
    private val em: EntityManager? = null

    @Bean
    fun jpaQueryFactory(): JPAQueryFactory? {
        return JPAQueryFactory(em)
    }
}