package com.illunex.invest.shop.persistence.repository.impl

import com.illunex.invest.shop.persistence.entity.Plugin
import com.illunex.invest.shop.persistence.entity.PluginRole
import com.illunex.invest.shop.persistence.repository.ShopPluginRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
        , properties = ["eureka.client.enabled=false"
    , "spring.cloud.config.enabled=false"
    , "spring.datasource.url=jdbc:h2:mem:shop"])
@Transactional
class ShopPluginRepositoryImplTest {
    @Autowired
    var shopPluginRepository: ShopPluginRepository? = null
    @Before
    fun setUp() {
        var pluginRoleIr:ArrayList<PluginRole> = ArrayList()
        pluginRoleIr.add(PluginRole("RIR"))

        var pluginRoleProduct:ArrayList<PluginRole> = ArrayList()
        pluginRoleProduct.add(PluginRole("Rproduct"))

        var pluginRoleTeam:ArrayList<PluginRole> = ArrayList()
        pluginRoleTeam.add(PluginRole("Rteam"))

        shopPluginRepository!!.save(Plugin("IR", pluginRoleIr))
        shopPluginRepository!!.save(Plugin("Product", pluginRoleProduct))
        shopPluginRepository!!.save(Plugin("Team", pluginRoleTeam))
    }

    @Test
    fun findRoleByIds() {
        var ids:ArrayList<Long> = ArrayList()
        ids.add(1L)
        ids.add(3L)

        var test:List<String> = shopPluginRepository!!.findRoleByIds(ids)

        test.stream().forEach { s ->
            run {
                println(s)
            }
        }
    }
}

