package com.illunex.invest.investment.persistence.repository;

import com.illunex.invest.investment.persistence.entity.ReviewItemTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewItemTemplateRepository extends JpaRepository<ReviewItemTemplate, Long> {
    List<ReviewItemTemplate> findAllByCompanyIdxAndDeleted(Long companyIdx, Boolean deleted);
    List<ReviewItemTemplate> deleteAllByCompanyIdx(Long companyIdx);
}
