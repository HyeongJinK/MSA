package com.illunex.invest.invest.service

import com.illunex.invest.api.core.invest.dto.EvaluateDTO
import com.illunex.invest.api.core.invest.dto.JudgeDTO
import com.illunex.invest.api.core.invest.dto.ReviewItemDTO
import com.illunex.invest.invest.persistence.entity.Evaluate
import com.illunex.invest.invest.persistence.repository.EvaluateRepository
import com.illunex.invest.invest.persistence.repository.JudgeRepository
import com.illunex.invest.invest.persistence.repository.ReviewItemRepository
import com.illunex.invest.invest.service.mapper.EvaluateMapper
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class EvaluateService {
    @Autowired var evaluateRepository:EvaluateRepository? = null
    @Autowired var judgeRepository: JudgeRepository? = null
    @Autowired var reviewItemRepository: ReviewItemRepository? = null

    private val mapper: EvaluateMapper = Mappers.getMapper(EvaluateMapper::class.java)

    fun setEvaluate(companyIdx: Long, vcCompanyIdx: Long):String {

        val evaluate = Evaluate()
        evaluate.companyIdx = companyIdx
        evaluate.vcCompanyIdx = vcCompanyIdx

        evaluateRepository!!.save(evaluate)
        return "success"

//        return if (evaluateRepository!!.findByCompanyIdxAndVcCompanyIdx(companyIdx, vcCompanyIdx).equals(null) ) {
//            evaluateRepository!!.save(Evaluate(companyIdx = companyIdx, vcCompanyIdx = vcCompanyIdx))
//            "Evaluate set complete"
//        } else {
//            "Already exists Evaluate "
//        }
    }

    fun getEvaluateList(companyIdx:Long):List<EvaluateDTO> {
        return mapper.evaluateListEntityToDTOList(evaluateRepository!!.findAllByCompanyIdx(companyIdx))
    }

    fun getEvaluate(evaluateIdx:Long):EvaluateDTO {
        return mapper.evaluateEntityToDTO(evaluateRepository!!.findById(evaluateIdx).get())
    }

    fun editEvaluate(evaluateDTO: EvaluateDTO):String {
        evaluateRepository!!.save(mapper.evaluateDTOToEntity(evaluateDTO))
        return "Evaluate edit complete"
    }

    fun editJudge(judgeDTO: JudgeDTO):String {
        judgeRepository!!.save(mapper.judgeDTOToEntity(judgeDTO))
        return "Judge edit complete"
    }

    fun editReviewItem(reviewItemDTO: ReviewItemDTO):String {
        reviewItemRepository!!.save(mapper.reviewItemDTOToEntity(reviewItemDTO))
        return "ReviewItem edit complete"
    }

}