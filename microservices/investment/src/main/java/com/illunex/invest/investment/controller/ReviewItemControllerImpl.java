package com.illunex.invest.investment.controller;

import com.illunex.invest.api.core.investment.controller.ReviewItemController;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import com.illunex.invest.api.core.investment.dto.ReviewItemTemplateDTO;
import com.illunex.invest.investment.service.ReviewItemService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewItemControllerImpl implements ReviewItemController {
    private Log log = LogFactory.getLog(ReviewItemControllerImpl.class);

    final ReviewItemService reviewItemService;

    public ReviewItemControllerImpl(ReviewItemService itemService) { this.reviewItemService = itemService; }

    @Override
    public ResponseEntity<ListDTO> getReviewItemList(Long companyIdx) {
        return new ResponseEntity(reviewItemService.getReviewItemList(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ReviewItemTemplateDTO> getReviewItem(Long templateIdx) {
        return new ResponseEntity(reviewItemService.getReviewItem(templateIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> editReviewItem(ReviewItemTemplateDTO reviewItemTemplateDTO) {
        return new ResponseEntity(reviewItemService.editReviewItem(reviewItemTemplateDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteReviewItem(ReviewItemTemplateDTO reviewItemTemplateDTO) {
        return new ResponseEntity(reviewItemService.deleteReviewItem(reviewItemTemplateDTO), HttpStatus.OK);
    }
}
