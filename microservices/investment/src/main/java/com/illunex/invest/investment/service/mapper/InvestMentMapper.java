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

    EvaluateCardDTO evaluateCardEntityToDTO(Evaluate evaluate);
    List<EvaluateCardDTO> evaluateCardListEntityToDTO(List<Evaluate> evaluateList);

    EvaluateStateDTO evaluateStateEntityToDTO(Evaluate evaluate);
    List<EvaluateStateDTO> evaluateStateListEntityToDTO(List<Evaluate> evaluateList);

    EvaluateCardJudgeDTO evaluateCardJudgeEntityToDTO(EvaluateJudge evaluateJudge);
    List<EvaluateCardJudgeDTO> evaluateCardJudgeListEntityToDTO(List<EvaluateJudge> evaluateJudgeList);

    // evaluate > judgeList > scoreList
    EvaluateJudge evaluateJudgeDTOToEntity(EvaluateJudgeDTO evaluateJudgeDTO);
    EvaluateJudgeDTO evaluateJudgeEntityToDTO(EvaluateJudge evaluateJudge);

    List<EvaluateJudge> evaluateJudgeListDTOToEntity(List<EvaluateJudgeDTO> evaluateJudgeDTOList);
    List<EvaluateJudgeDTO> evaluateJudgeListEntityToDTO(List<EvaluateJudge> evaluateJudgeList);

    EvaluateJudgeScore evaluateJudgeScoreDTOToEntity(EvaluateJudgeScoreDTO evaluateJudgeScoreDTO);
    EvaluateJudgeScoreDTO evaluateJudgeScoreEntityToDTO(EvaluateJudgeScore evaluateJudgeScore);

    List<EvaluateJudgeScore> evaluateJudgeScoreListDTOToEntity(List<EvaluateJudgeScoreDTO> evaluateJudgeScoreDTOList);
    List<EvaluateJudgeScoreDTO> evaluateJudgeScoreListEntityToDTO(List<EvaluateJudgeScore> evaluateJudgeScoreList);

    // evaluate > template > categoryList > itemList
    EvaluateReviewItemTemplate evaluateReviewItemTemplateDTOToEntity(EvaluateReviewItemTemplateDTO reviewItemTemplateDTO);
    EvaluateReviewItemTemplateDTO evaluateReviewItemTemplateEntityToDTO(EvaluateReviewItemTemplate reviewItemTemplate);

    List<EvaluateReviewItemTemplate> evaluateReviewItemTemplateListDTOToEntity(List<EvaluateReviewItemTemplateDTO> evaluateReviewItemTemplateDTOList);
    List<EvaluateReviewItemTemplateDTO> evaluateReviewItemTemplateListEntityToDTO(List<EvaluateReviewItemTemplate> evaluateReviewItemTemplateList);

    EvaluateReviewItemCategory evaluateReviewItemCategoryDTOToEntity(EvaluateReviewItemCategoryDTO reviewItemCategoryDTO);
    EvaluateReviewItemCategoryDTO evaluateReviewItemCategoryEntityToDTO(EvaluateReviewItemCategory reviewItemCategory);

    List<EvaluateReviewItemCategory> evaluateReviewItemCategoryListDTOToEntity(List<EvaluateReviewItemCategoryDTO> evaluateReviewItemCategoryDTOList);
    List<EvaluateReviewItemCategoryDTO> evaluateReviewItemCategoryListEntityToDTO(List<EvaluateReviewItemCategory> evaluateReviewItemCategoryList);

    EvaluateReviewItem evaluateReviewItemDTOToEntity(EvaluateReviewItemDTO reviewItemDTO);
    EvaluateReviewItemDTO evaluateReviewItemEntityToDTO(EvaluateReviewItem reviewItem);

    List<EvaluateReviewItem> evaluateReviewItemListDTOToEntity(List<EvaluateReviewItemDTO> evaluateReviewItemDTOList);
    List<EvaluateReviewItemDTO> evaluateReviewItemListEntityToDTO(List<EvaluateReviewItem> evaluateReviewItemList);

    // judge
    Judge judgeDTOToEntity(JudgeDTO judgeDTO);
    JudgeDTO judgeEntityToDTO(Judge judge);

    List<Judge> judgeListDTOToEntity(List<JudgeDTO> judgeDTOList);
    List<JudgeDTO> judgeListEntityToDTO(List<Judge> judgeList);

    // favoriteCompany

    FavoriteCompany favoriteCompanyDTOToEntity(FavoriteCompanyDTO favoriteCompanyDTO);
    FavoriteCompanyDTO favoriteCompanyEntityToDTO(FavoriteCompany favoriteCompany);

    List<FavoriteCompany> favoriteCompanyListDTOToEntity(List<FavoriteCompanyDTO> favoriteCompanyDTOList);
    List<FavoriteCompanyDTO> favoriteCompanyListEntityToDTO(List<FavoriteCompany> favoriteCompanyList);

    // template > categoryList > itemList
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
