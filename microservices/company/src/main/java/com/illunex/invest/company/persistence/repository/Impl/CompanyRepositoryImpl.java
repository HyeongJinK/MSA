package com.illunex.invest.company.persistence.repository.Impl;

import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.QCompany;
import com.illunex.invest.company.persistence.entity.QMainProductLine;
import com.illunex.invest.company.persistence.repository.custom.CompanyCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.Optional;

/**
 * 사용자 정의 리파지토리 클래
 * */
@RequiredArgsConstructor
@Log
public class CompanyRepositoryImpl implements CompanyCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Company> findByCompanyIdx(Long idx) {
        QCompany company = QCompany.company;
        log.info("==================================");
        log.info(idx.toString());
        return Optional.of(queryFactory.selectFrom(company)
                .leftJoin(company.mainProductLines, QMainProductLine.mainProductLine).fetchJoin()
                .where(company.companyIdx.eq(idx))
                .fetchOne());
    }
}