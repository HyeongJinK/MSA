package com.illunex.invest.investment.service.mapper;

import com.illunex.invest.api.core.investment.dto.*;
import com.illunex.invest.investment.persistence.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InvestMentMapper {
    InvestMentMapper MAPPER = Mappers.getMapper( InvestMentMapper.class );

    Evaluate evaluateDTOToEntity(EvaluateDTO evaluateDTO);
    EvaluateDTO evaluateEntityToDTO(Evaluate evaluate);

    List<Evaluate> evaluateListDTOToEntity(List<EvaluateDTO> evaluateDTOList);
    List<EvaluateDTO> evaluateListEntityToDTO(List<Evaluate> evaluateList);

    EvaluateJudge evaluateJudgeDTOToEntity(EvaluateJudgeDTO evaluateJudgeDTO);
    EvaluateJudgeDTO evaluateJudgeEntityToDTO(EvaluateJudge evaluateJudge);

    List<EvaluateJudge> evaluateJudgeListDTOToEntity(List<EvaluateJudgeDTO> evaluateJudgeDTOList);
    List<EvaluateJudgeDTO> evaluateJudgeListEntityToDTO(List<EvaluateJudge> evaluateJudgeList);

    EvaluateReviewItemCategory evaluateReviewItemCategoryDTOToEntity(EvaluateReviewItemCategoryDTO reviewItemCategoryDTO);
    EvaluateReviewItemCategoryDTO evaluateReviewItemCategoryEntityToDTO(EvaluateReviewItemCategory reviewItemCategory);

    List<EvaluateReviewItemCategory> evaluateReviewItemCategoryListDTOToEntity(List<EvaluateReviewItemCategoryDTO> evaluateReviewItemCategoryDTOList);
    List<EvaluateReviewItemCategoryDTO> evaluateReviewItemCategoryListEntityToDTO(List<EvaluateReviewItemCategory> evaluateReviewItemCategoryList);

    EvaluateReviewItem evaluateReviewItemDTOToEntity(EvaluateReviewItemDTO reviewItemDTO);
    EvaluateReviewItemDTO evaluateReviewItemEntityToDTO(EvaluateReviewItem reviewItem);

    List<EvaluateReviewItem> evaluateReviewItemListDTOToEntity(List<EvaluateReviewItemDTO> evaluateReviewItemDTOList);
    List<EvaluateReviewItemDTO> evaluateReviewItemListEntityToDTO(List<EvaluateReviewItem> evaluateReviewItemList);

    Judge judgeDTOToEntity(JudgeDTO judgeDTO);
    JudgeDTO judgeEntityToDTO(Judge judge);

    List<Judge> judgeListDTOToEntity(List<JudgeDTO> judgeDTOList);
    List<JudgeDTO> judgeListEntityToDTO(List<Judge> judgeList);

    ReviewItemTemplate reviewItemTemplateDTOToEntity(ReviewItemTemplateDTO reviewItemTemplateDTO);
    ReviewItemTemplateDTO reviewItemTemplateEntityToDTO(ReviewItemTemplate reviewItemTemplate);

    List<ReviewItemTemplate> reviewItemTemplateListDTOToEntity(List<ReviewItemTemplateDTO> reviewItemTemplateDTOList);
    List<ReviewItemTemplateDTO> reviewItemTemplateListEntityToDTO(List<ReviewItemTemplate> reviewItemTemplateList);

    ReviewItemCategory reviewItemCategoryDTOToEntity(ReviewItemCategoryDTO reviewItemCategoryDTO);
    ReviewItemCategoryDTO reviewItemCategoryEntityToDTO(ReviewItemCategory reviewItemCategory);

    List<ReviewItemCategory> reviewItemCategoryListDTOToEntity(List<ReviewItemCategoryDTO> reviewItemCategoryDTOList);
    List<ReviewItemCategoryDTO> reviewItemCategoryListEntityToDTO(List<ReviewItemCategory> reviewItemCategoryList);

    ReviewItem reviewItemDTOToEntity(ReviewItemDTO reviewItemDTO);
    ReviewItemDTO reviewItemEntityToDTO(ReviewItem reviewItem);

    List<ReviewItem> reviewItemListDTOToEntity(List<ReviewItemDTO> reviewItemDTOList);
    List<ReviewItemDTO> reviewItemListEntityToDTO(List<ReviewItem> reviewItemList);

}
