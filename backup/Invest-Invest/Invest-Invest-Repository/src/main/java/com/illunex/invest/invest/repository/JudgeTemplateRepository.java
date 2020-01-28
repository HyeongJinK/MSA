package com.illunex.invest.invest.repository;

import com.illunex.invest.invest.entity.JudgeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JudgeTemplateRepository extends JpaRepository<JudgeTemplate, Long> {
    List<JudgeTemplate> findAllByUserIdx(Long userIdx);
}
