package com.illunex.invest.company.persistence.repository.Impl;

import com.illunex.invest.company.persistence.entity.QCompany;
import com.illunex.invest.company.persistence.repository.custom.CompanyCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 사용자 정의 리파지토리 클래
 * */
public class CompanyRepositoryImpl implements CompanyCustomRepository {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public void templateFunc(Long idx) {
        /**
         * 템플릿 함수
         * */
        QCompany company = QCompany.company;

        queryFactory.selectFrom(company)
                .where(company.name.eq("test")
                    .and(company.companyIdx.eq(idx)))
                .orderBy(company.companyIdx.asc())
                .fetch();
    }
}
