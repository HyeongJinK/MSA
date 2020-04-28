package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.investment.dto.*;
import com.illunex.invest.investment.persistence.entity.*;
import com.illunex.invest.investment.persistence.repository.*;
import com.illunex.invest.investment.service.mapper.InvestMentMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewItemService {
    private Log log = LogFactory.getLog(ReviewItemService.class);

    @Autowired ReviewItemTemplateRepository reviewItemTemplateRepository;
    @Autowired ReviewItemCategoryRepository reviewItemCategoryRepository;
    @Autowired ReviewItemRepository reviewItemRepository;

    private InvestMentMapper mapper = Mappers.getMapper(InvestMentMapper.class);

    public ListDTO getReviewItemList(Long companyIdx) {

        List<ReviewItemTemplate> reviewItemTemplateList = reviewItemTemplateRepository.findAllByCompanyIdxAndDeleted(companyIdx, false);

        if (reviewItemTemplateList.size() == 0) {
            ReviewItemTemplate defaultItem = ReviewItemTemplate.builder()
                .title("기본 심사 평가항목 템플릿")
                .deleted(false)
                .weightApply(false)
                .point(0)
                .updateDate(LocalDateTime.now())
                .companyIdx(companyIdx)
                .build();

            ReviewItemCategory reviewItemCategory = ReviewItemCategory.builder()
                    .category("기본 평가항목 카테고리")
                    .weight(0)
                    .reviewItemTemplate(defaultItem)
                    .build();

            List<ReviewItem> reviewItemList = new ArrayList();
            reviewItemList.add(0, ReviewItem.builder()
                    .content("기본 심사내용")
                    .reviewItemCategory(reviewItemCategory)
                    .build());

            List<ReviewItemCategory> reviewItemCategoryList = new ArrayList();
            reviewItemCategoryList.add(0, reviewItemCategory);

            reviewItemCategory.setReviewItem(reviewItemList);
            defaultItem.setReviewItemCategory(reviewItemCategoryList);

            reviewItemTemplateRepository.save(defaultItem);

            List<ReviewItemTemplate> defaultList = new ArrayList();
            defaultList.add(defaultItem);

            return ListDTO.builder().reviewItemTemplateList(mapper.reviewItemTemplateListEntityToDTO(defaultList)).build();
        } else {
            return ListDTO.builder().reviewItemTemplateList(mapper.reviewItemTemplateListEntityToDTO(reviewItemTemplateList)).build();
        }
    }

    public ReviewItemTemplateDTO getReviewItem(Long templateIdx) {
        return mapper.reviewItemTemplateEntityToDTO(reviewItemTemplateRepository.findById(templateIdx).get());
    }

    @Transactional
    public String editReviewItem(ReviewItemTemplateDTO reviewItemTemplateDTO) {
        ReviewItemTemplate newTemplate = mapper.reviewItemTemplateDTOToEntity(reviewItemTemplateDTO);

        if (reviewItemTemplateDTO.getIdx() == null) {
            for (ReviewItemCategory c: newTemplate.getReviewItemCategory()) {
                for (ReviewItem i: c.getReviewItem()) {
                    i.setReviewItemCategory(c);
                }
                c.setReviewItemTemplate(newTemplate);
            }

            newTemplate.setCompanyIdx(reviewItemTemplateDTO.getCompanyIdx());
            newTemplate.setUpdateDate(LocalDateTime.now());
            newTemplate.setPoint(0);
            newTemplate.setWeightApply(false);
            newTemplate.setDeleted(false);
            reviewItemTemplateRepository.save(newTemplate);

            return "ReviewItem Template Create Success";
        } else {
            ReviewItemTemplate template = reviewItemTemplateRepository.findById(reviewItemTemplateDTO.getIdx()).orElse(null);

            if (template == null) {
                return "Invalid ReviewItem Template";
            } else {

                for (ReviewItemCategory c: newTemplate.getReviewItemCategory()) {
                    for (ReviewItem i: c.getReviewItem()) {
                        reviewItemRepository.deleteAllByReviewItemCategoryIdx(c.getIdx());
                        i.setReviewItemCategory(c);
                    }
                    reviewItemCategoryRepository.deleteAllByReviewItemTemplateIdx(newTemplate.getIdx());
                    c.setReviewItemTemplate(newTemplate);
                }

                template.setTitle(newTemplate.getTitle());
                template.setPoint(newTemplate.getPoint());
                template.setWeightApply(newTemplate.getWeightApply());
                template.setUpdateDate(LocalDateTime.now());
                template.setReviewItemCategory(newTemplate.getReviewItemCategory());
                reviewItemTemplateRepository.save(template);

                return "ReviewItem Template Edit Success";
            }
        }
    }

    public String deleteReviewItem(ReviewItemTemplateDTO reviewItemTemplateDTO) {
        reviewItemTemplateRepository.deleteById(reviewItemTemplateDTO.getIdx());
        return "ReviewItem delete complete";
    }

}
