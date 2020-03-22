package com.illunex.invest.shop.controller

import com.illunex.invest.api.common.response.ResponseList
import com.illunex.invest.api.core.shop.controller.PluginController
import com.illunex.invest.shop.service.ShopPluginService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors

@RestController
class PluginControllerImpl: PluginController {
    @Autowired var shopPluginService:ShopPluginService? = null

    override fun getRoleNameByIds(ids: List<String>): ResponseEntity<ResponseList<String>> {
        return ResponseEntity.ok(ResponseList(0
                , "success"
                , shopPluginService!!.getRoleNamesByPluginId(ids.stream()
                    .map { s: String -> s.toLong() }
                    .collect(Collectors.toList()))
        ))
    }
}