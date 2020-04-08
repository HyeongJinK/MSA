package com.illunex.invest.invest.service.mapper

import com.illunex.invest.api.core.invest.dto.EvaluateDTO
import com.illunex.invest.api.core.invest.dto.JudgeDTO
import com.illunex.invest.api.core.invest.dto.ReviewItemDTO
import com.illunex.invest.invest.persistence.entity.Evaluate
import com.illunex.invest.invest.persistence.entity.Judge
import com.illunex.invest.invest.persistence.entity.ReviewItem
import java.util.stream.Collectors

class EvaluateMapper {
    fun DtoTOEntity(evaluate: Evaluate): EvaluateDTO {
        var evaluateDTO: EvaluateDTO = EvaluateDTO();

        return evaluateDTO;
    }

    fun DtoTOEntity(evaluate: List<Evaluate>): List<EvaluateDTO> {
        var evaluateDTOList: ArrayList<EvaluateDTO> = ArrayList()

        evaluate.stream().forEach { evaluate ->
            run {
                evaluateDTOList.add(EvaluateDTO(evaluate.idx
                        , evaluate.companyIdx
                        , evaluate.product
                        , evaluate.company
                        , evaluate.imgUrl
                        , evaluate.updateDate
                        , evaluate.scale
                        , evaluate.status
                        , evaluate.score
                        , evaluate.judges
                        , evaluate.reviewItem))
            }
        }

        return evaluateDTOList;
    }

    private fun EvaluateDTO(idx: Long?, companyIdx: Long?, product: String, company: String, imgUrl: String, updateDate: String, scale: String, status: String, score: Int, judges: List<Judge>, reviewItem: List<ReviewItem>): EvaluateDTO {
        return EvaluateDTO(idx
                , companyIdx
                , product
                , company
                , imgUrl
                , updateDate
                , scale
                , status
                , score
                , judges.stream().map { item -> JudgeDTO(item.idx, item.userIdx, item.name, item.comment, item.point, item.rank, item.imgUrl, item.status) }.collect(Collectors.toList()) as List<JudgeDTO>
                , reviewItem.stream().map { item -> ReviewItemDTO(item.idx, item.category, item.title, item.point, item.content, item.updateDate, item.deleted) }.collect(Collectors.toList()) as List<ReviewItemDTO>)
    }

}