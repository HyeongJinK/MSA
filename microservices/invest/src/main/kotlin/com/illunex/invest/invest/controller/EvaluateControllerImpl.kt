package com.illunex.invest.invest.controller

import com.illunex.invest.api.core.invest.controller.EvaluateController
import com.illunex.invest.api.core.invest.dto.EvaluateDTO
import com.illunex.invest.invest.service.EvaluateService
import com.illunex.invest.invest.service.mapper.EvaluateMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EvaluateControllerImpl: EvaluateController {
    @Autowired var evaluateService:EvaluateService? = null

    private var evaluateMapper: EvaluateMapper = EvaluateMapper()

    override fun getEvaluateList(companyIdx: Long?): ResponseEntity<List<EvaluateDTO>> {
        return ResponseEntity.ok(evaluateMapper.DtoTOEntity(evaluateService!!.getEvaluateList(companyIdx!!)))
    }

}