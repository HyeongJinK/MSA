package com.illunex.invest.investment.service.mapper;

import com.illunex.invest.api.core.invest.dto.*;
import com.illunex.invest.investment.persistence.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EvaluateMapper {
    EvaluateMapper MAPPER = Mappers.getMapper( EvaluateMapper.class );

    Evaluate evaluateDTOToEntity(EvaluateDTO evaluateDTO);
    EvaluateDTO evaluateEntityToDTO(Evaluate evaluate);

    List<Evaluate> evaluateListDTOToEntity(List<EvaluateDTO> evaluateDTOList);
    List<EvaluateDTO> evaluateListEntityToDTO(List<Evaluate> evaluateList);

    EvaluateJudge evaluateJudgeDTOToEntity(EvaluateJudgeDTO evaluateJudgeDTO);
    EvaluateJudgeDTO evaluateJudgeEntityToDTO(EvaluateJudge evaluateJudge);

    List<EvaluateJudge> evaluateJudgeListDTOToEntity(List<EvaluateJudgeDTO> evaluateJudgeDTOList);
    List<EvaluateJudgeDTO> evaluateJudgeListEntityToDTO(List<EvaluateJudge> evaluateJudgeList);

    EvaluateReviewItem evaluateReviewItemDTOToEntity(EvaluateReviewItemDTO reviewItemDTO);
    EvaluateReviewItemDTO evaluateReviewItemEntityToDTO(EvaluateReviewItem reviewItem);

    List<EvaluateReviewItem> evaluateReviewItemListDTOToEntity(List<EvaluateReviewItemDTO> evaluateReviewItemDTOList);
    List<EvaluateReviewItemDTO> evaluateReviewItemListEntityToDTO(List<EvaluateReviewItem> evaluateReviewItemList);

    Judge judgeDTOToEntity(JudgeDTO judgeDTO);
    JudgeDTO judgeEntityToDTO(Judge judge);

    List<Judge> judgeListDTOToEntity(List<JudgeDTO> judgeDTOList);
    List<JudgeDTO> judgeListEntityToDTO(List<Judge> judgeList);

    ReviewItem reviewItemDTOToEntity(ReviewItemDTO reviewItemDTO);
    ReviewItemDTO reviewItemEntityTo(ReviewItem reviewItem);

    List<ReviewItem> reviewItemListDTOToEntity(List<ReviewItemDTO> reviewItemDTOList);
    List<ReviewItemDTO> reviewItemListEntityToDTO(List<ReviewItem> reviewItemList);

}
