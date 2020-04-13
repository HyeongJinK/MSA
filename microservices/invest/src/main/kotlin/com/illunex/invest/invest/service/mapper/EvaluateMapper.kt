package com.illunex.invest.invest.service.mapper

import com.illunex.invest.api.core.investment.dto.EvaluateDTO
import com.illunex.invest.api.core.investment.dto.JudgeDTO
import com.illunex.invest.api.core.investment.dto.ReviewItemDTO
import com.illunex.invest.invest.persistence.entity.Evaluate
import com.illunex.invest.invest.persistence.entity.Judge
import com.illunex.invest.invest.persistence.entity.ReviewItem
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface EvaluateMapper {
    var MAPPER: EvaluateMapper
        get() = Mappers.getMapper(EvaluateMapper::class.java)
        set(value) = TODO()

    fun evaluateEntityToDTO(evaluate: Evaluate) : EvaluateDTO
    fun evaluateDTOToEntity(evaluateDTO: EvaluateDTO) : Evaluate

    fun evaluateListEntityToDTOList(evaluateList: List<Evaluate>) : List<EvaluateDTO>

    fun judgeEntityToDTO(judge: Judge) : JudgeDTO
    fun judgeDTOToEntity(judgeDTO: JudgeDTO) : Judge
    fun reviewItemEntityToDTO(reviewItem: ReviewItem) : ReviewItemDTO
    fun reviewItemDTOToEntity(reviewItemDTO: ReviewItemDTO) : ReviewItem

//
//    private fun EvaluateDTO(idx: Long?, companyIdx: Long?, vcCompanyIdx: Long?, product: String?, company: String?, imgUrl: String?, updateDate: String?, scale: String?, status: String?, content: String?, score: Int?, judgeList: List<EvaluateJudge>, category: EvaluateReviewItemCategory?): EvaluateDTO
//    {
//
//        return EvaluateDTO(idx
//            , companyIdx
//            , vcCompanyIdx
//            , product
//            , company
//            , imgUrl
//            , updateDate
//            , scale
//            , status
//            , content
//            , score
//            , judgeList.stream().map { item -> EvaluateJudgeDTO(item.idx, item.userIdx, item.name, item.comment, item.point, item.rank, item.imgUrl, item.status) }.collect(Collectors.toList()) as List<EvaluateJudge>
//            , category)
//
//
//    }
//
//    private fun Evaluate(idx: Long?, companyIdx: Long?, vcCompanyIdx: Long?, product: String, company: String, imgUrl: String, updateDate: String, scale: String, status: String, content: String, score: Int, judgeList: List<EvaluateJudgeDTO>, category: CategoryDTO): Evaluate {
//        return Evaluate(
//                idx, companyIdx, vcCompanyIdx, product, company, imgUrl, updateDate, scale, status, content, score, judgeList, category
//        )
//    }
//
//    fun evaluateEntityToDTO(evaluate: Evaluate): EvaluateDTO {
//        val evaluateDTO = EvaluateDTO(
//              evaluate.idx
//            , evaluate.companyIdx
//            , evaluate.vcCompanyIdx
//            , evaluate.product
//            , evaluate.company
//            , evaluate.imgUrl
//            , evaluate.updateDate
//            , evaluate.scale
//            , evaluate.status
//            , evaluate.content
//            , evaluate.score
//            , evaluate.judgeList
//            , evaluate.category)
//
//        return evaluateDTO
//    }
//
//    fun evaluateDTOToEntity(evaluateDTO: EvaluateDTO): Evaluate {
//        val evaluate = Evaluate(
//            evaluateDTO.idx
//            , evaluateDTO.companyIdx
//            , evaluateDTO.vcCompanyIdx
//            , evaluateDTO.product
//            , evaluateDTO.company
//            , evaluateDTO.imgUrl
//            , evaluateDTO.updateDate
//            , evaluateDTO.scale
//            , evaluateDTO.status
//            , evaluateDTO.content
//            , evaluateDTO.score
//            , evaluateDTO.judgeList
//            , evaluateDTO.category)
//
//        return evaluate
//    }
//
//    fun judgeDTOToEntity(judgeDTO: JudgeDTO): Judge {
//        val judge = Judge(
//            judgeDTO.idx
//            , judgeDTO.userIdx
//            , judgeDTO.name
//            , judgeDTO.rank
//            , judgeDTO.imgUrl
//        )
//
//        return judge
//    }
//
//    fun reviewItemDTOToEntity(reviewItemDTO: ReviewItemDTO): ReviewItem {
//        val reviewItem = ReviewItem(
//            reviewItemDTO.idx
//            , reviewItemDTO.title
//            , reviewItemDTO.point
//            , reviewItemDTO.updateDate
//        )
//        return reviewItem
//    }
//
//
//    fun entityListToDTOList(evaluate: List<Evaluate>): List<EvaluateDTO> {
//        val evaluateDTOList: ArrayList<EvaluateDTO> = ArrayList()
//
//        evaluate.stream().forEach { evaluate ->
//            run {
//                evaluateDTOList.add(EvaluateDTO(
//                      evaluate.idx
//                    , evaluate.companyIdx
//                    , evaluate.vcCompanyIdx
//                    , evaluate.product
//                    , evaluate.company
//                    , evaluate.imgUrl
//                    , evaluate.updateDate
//                    , evaluate.scale
//                    , evaluate.status
//                    , evaluate.content
//                    , evaluate.score
//                    , evaluate.judgeList
//                    , evaluate.category))
//            }
//        }
//
//        return evaluateDTOList;
//    }


}