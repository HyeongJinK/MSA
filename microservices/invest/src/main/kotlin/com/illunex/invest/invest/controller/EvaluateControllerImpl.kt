package com.illunex.invest.invest.controller

import com.illunex.invest.api.core.invest.controller.EvaluateController
import com.illunex.invest.api.core.invest.dto.EvaluateDTO
import com.illunex.invest.api.core.invest.dto.EvaluateListDTO
import com.illunex.invest.invest.service.EvaluateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EvaluateControllerImpl: EvaluateController {
    @Autowired var evaluateService:EvaluateService? = null

    override fun getEvaluateList(companyIdx: Long): ResponseEntity<EvaluateListDTO> {
        val evaluateListDTO = EvaluateListDTO()
        evaluateListDTO.evaluateList = evaluateService!!.getEvaluateList(companyIdx)

        return ResponseEntity.ok(evaluateListDTO)
    }

    override fun getEvaluate(evaluateIdx: Long): ResponseEntity<EvaluateDTO> {
        return ResponseEntity.ok(evaluateService!!.getEvaluate(evaluateIdx))
    }

}