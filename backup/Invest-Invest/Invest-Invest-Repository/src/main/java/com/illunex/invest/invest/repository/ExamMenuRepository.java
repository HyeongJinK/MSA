package com.illunex.invest.invest.repository;

import com.illunex.invest.invest.entity.ExamMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamMenuRepository extends JpaRepository<ExamMenu, Long> {
    List<ExamMenu> findAllByUserIdx(Long userIdx);
}
