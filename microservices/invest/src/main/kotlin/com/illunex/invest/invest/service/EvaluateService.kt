package com.illunex.invest.invest.service

import com.illunex.invest.invest.persistence.entity.Evaluate
import com.illunex.invest.invest.persistence.repository.EvaluateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class EvaluateService {
    @Autowired var evaluateRepository:EvaluateRepository? = null

    fun getEvaluateList(companyIdx:Long):List<Evaluate> {
        return evaluateRepository!!.findAllByCompanyIdx(companyIdx)
    }
}