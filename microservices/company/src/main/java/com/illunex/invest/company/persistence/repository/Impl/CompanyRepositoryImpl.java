package com.illunex.invest.company.persistence.repository.Impl;

import com.illunex.invest.company.persistence.entity.QCompanyEntity;
import com.illunex.invest.company.persistence.repository.custom.CompanyCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 정의 리파지토리 클래
 * */
@RequiredArgsConstructor
public class CompanyRepositoryImpl implements CompanyCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public void templateFunc(Long idx) {
        /**
         * 템플릿 함수
         * */
        QCompanyEntity company = QCompanyEntity.companyEntity;

        queryFactory.selectFrom(company)
                .where(company.name.eq("test")
                    .and(company.companyIdx.eq(idx)))
                .orderBy(company.companyIdx.asc())
                .fetch();
    }
}
