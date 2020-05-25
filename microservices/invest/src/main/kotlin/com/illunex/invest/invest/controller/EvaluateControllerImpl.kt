package com.illunex.invest.invest.controller

import com.illunex.invest.api.core.investment.dto.*
import com.illunex.invest.invest.service.EvaluateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import com.illunex.invest.api.core.investment.controller.EvaluateController as EvaluateController1

@RestController
class EvaluateControllerImpl: EvaluateController1 {
    @Autowired var evaluateService:EvaluateService? = null
    override fun rejectEvaluate(evaluateDTO: EvaluateDTO?): ResponseEntity<String> {
        TODO("Not yet implemented")
    }

    override fun review(evaluateReviewDTO: EvaluateReviewDTO?): ResponseEntity<String> {
        TODO("Not yet implemented")
    }

    override fun editComment(evaluateCommentDTO: EvaluateCommentDTO?): ResponseEntity<String> {
        TODO("Not yet implemented")
    }

    override fun deleteEvaluate(evaluateDTO: EvaluateDTO?): ResponseEntity<String> {
        TODO("Not yet implemented")
    }

    override fun confirmEvaluate(evaluateDTO: EvaluateDTO?): ResponseEntity<String> {
        TODO("Not yet implemented")
    }

    override fun getEvaluateList(companyIdx: Long?): ResponseEntity<EvaluateListDTO> {
        TODO("Not yet implemented")
    }

    override fun getEvaluate(evaluateIdx: Long?): ResponseEntity<EvaluateDTO> {
        TODO("Not yet implemented")
    }

    override fun editEvaluate(evaluateDTO: EvaluateDTO?): ResponseEntity<String> {
        TODO("Not yet implemented")
    }

    override fun getEvaluateHistory(companyIdx: Long?): ResponseEntity<EvaluateListDTO> {
        TODO("Not yet implemented")
    }

    override fun setEvaluate(evaluateDTO: EvaluateDTO?): ResponseEntity<String> {
        TODO("Not yet implemented")
    }

    override fun getEvaluateStateList(companyIdx: Long?): ResponseEntity<EvaluateStateListDTO> {
        TODO("Not yet implemented")
    }

    override fun getEvaluateCardList(companyIdx: Long?): ResponseEntity<EvaluateCardListDTO> {
        TODO("Not yet implemented")
    }

//    override fun setEvaluate(companyIdx: Long, vcCompanyIdx: Long): ResponseEntity<String> {
//        return ResponseEntity.ok(evaluateService!!.setEvaluate(companyIdx, vcCompanyIdx))
//    }
//
//    override fun getEvaluateList(companyIdx: Long): ResponseEntity<EvaluateListDTO> {
//        val evaluateListDTO = EvaluateListDTO()
//        evaluateListDTO.evaluateList = evaluateService!!.getEvaluateList(companyIdx)
//
//        return ResponseEntity.ok(evaluateListDTO)
//    }
//
//    override fun getEvaluate(evaluateIdx: Long): ResponseEntity<EvaluateDTO> {
//        return ResponseEntity.ok(evaluateService!!.getEvaluate(evaluateIdx))
//    }
//
//    override fun editEvaluate(evaluateDTO: EvaluateDTO): ResponseEntity<String> {
//        return ResponseEntity.ok(evaluateService!!.editEvaluate(evaluateDTO))
//    }
//
//    override fun editJudge(judgeDTO: JudgeDTO): ResponseEntity<String> {
//        return ResponseEntity.ok(evaluateService!!.editJudge(judgeDTO))
//    }
//
//    override fun editReviewItem(reviewItemDTO: ReviewItemDTO): ResponseEntity<String> {
//        return ResponseEntity.ok(evaluateService!!.editReviewItem(reviewItemDTO))
//    }

}