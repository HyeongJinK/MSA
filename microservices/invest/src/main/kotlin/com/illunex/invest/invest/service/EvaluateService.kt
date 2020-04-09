package com.illunex.invest.invest.service

import com.illunex.invest.api.core.invest.dto.EvaluateDTO
import com.illunex.invest.invest.persistence.entity.Evaluate
import com.illunex.invest.invest.persistence.repository.EvaluateRepository
import com.illunex.invest.invest.service.mapper.EvaluateMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class EvaluateService {
    @Autowired var evaluateRepository:EvaluateRepository? = null
    private var evaluateMapper: EvaluateMapper = EvaluateMapper()

    fun getEvaluateList(companyIdx:Long):List<EvaluateDTO> {
        return evaluateMapper.DtoTOEntity(evaluateRepository!!.findAllByCompanyIdx(companyIdx))
    }

    fun getEvaluate(evaluateIdx:Long):EvaluateDTO {
        return evaluateMapper.DtoTOEntity(evaluateRepository!!.findById(evaluateIdx).get())
    }

}