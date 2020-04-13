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
                .point(0)
                .updateDate(LocalDateTime.now())
                .companyIdx(companyIdx)
                .build();

            ReviewItemCategory reviewItemCategory = ReviewItemCategory.builder()
                    .category("기본 평가항목 카테고리")
                    .reviewItemTemplate(defaultItem)
                    .build();

            List<ReviewItem> reviewItemList = new ArrayList();
            reviewItemList.add(0, ReviewItem.builder()
                    .content("기본 심사내용")
                    .point(0)
                    .reviewItemCategory(reviewItemCategory)
                    .build());

            List<ReviewItemCategory> reviewItemCategoryList = new ArrayList();
            reviewItemCategoryList.add(0, reviewItemCategory);

            reviewItemCategory.setReviewItem(reviewItemList);
            defaultItem.setReviewItemCategory(reviewItemCategoryList);

            reviewItemTemplateRepository.save(defaultItem);
        }

        return ListDTO.builder().reviewItemTemplateList(mapper.reviewItemTemplateListEntityToDTO(reviewItemTemplateList)).build();
    }

    public ReviewItemTemplateDTO getReviewItem(Long templateIdx) {
        return mapper.reviewItemTemplateEntityToDTO(reviewItemTemplateRepository.findById(templateIdx).get());
    }

    @Transactional
    public String editReviewItem(ReviewItemTemplateDTO reviewItemTemplateDTO) {
        ReviewItemTemplate newTemplate = mapper.reviewItemTemplateDTOToEntity(reviewItemTemplateDTO);
        ReviewItemTemplate template = reviewItemTemplateRepository.findById(reviewItemTemplateDTO.getIdx()).orElse(null);

        if (template == null) {

            for (ReviewItemCategory c: newTemplate.getReviewItemCategory()) {
                for (ReviewItem i: c.getReviewItem()) {
                    i.setReviewItemCategory(c);
                }
                c.setReviewItemTemplate(newTemplate);
            }

            reviewItemTemplateRepository.save(newTemplate);

            return "ReviewItem Template Create Success";

        } else {

            reviewItemTemplateRepository.save(newTemplate);

            return "ReviewItem Template Edit Success";
        }
//
//
//        List<ReviewItemTemplate> reviewItemTemplateList = mapper.reviewItemTemplateListDTOToEntity(editDTO.getReviewItemTemplateList());
//
//        for (ReviewItemTemplate t: reviewItemTemplateList) {
//
//            for (ReviewItemCategory c: t.getReviewItemCategory()) {
//
//                for (ReviewItem i: c.getReviewItem()) {
//                    reviewItemRepository.deleteAllByReviewItemCategoryIdx(c.getIdx());
//                    i.setReviewItemCategory(c);
//                }
//
//                reviewItemCategoryRepository.deleteAllByReviewItemTemplateIdx(t.getIdx());
//                c.setReviewItemTemplate(t);
//
//            }
//
//            reviewItemTemplateRepository.deleteAllByCompanyIdx(editDTO.getCompanyIdx());
//        }
//
//        for (ReviewItemCategory r: reviewItemCategoryList) {
//
//            for (ReviewItem i: r.getReviewItem()) {
//                reviewItemRepository.deleteAllByReviewItemCategoryIdx(r.getIdx());
//                i.setReviewItemCategory(r);
//            }
//
//        }
//        reviewItemCategoryRepository.deleteAllByCompanyIdx(editDTO.getCompanyIdx());
//        reviewItemCategoryRepository.saveAll(reviewItemCategoryList);
//        return "ReviewItem edit complete";
    }

    public String deleteReviewItem(ReviewItemTemplateDTO reviewItemTemplateDTO) {
        reviewItemCategoryRepository.deleteById(reviewItemTemplateDTO.getIdx());
        return "ReviewItem delete complete";
    }

}
