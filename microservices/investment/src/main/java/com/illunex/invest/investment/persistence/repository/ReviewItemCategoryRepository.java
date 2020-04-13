package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.ReviewItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewItemCategoryRepository extends JpaRepository<ReviewItemCategory, Long> {
    List<ReviewItemCategory> deleteAllByReviewItemTemplateIdx(Long templateIdx);
}
