package com.illunex.invest.user.persistence.repository.Impl;

import com.illunex.invest.user.persistence.entity.QUser;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.custom.UserRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory queryFactory;
    @Override
    public List<User> findByCompanyIdx(Long companyIdx) {
        QUser user = QUser.user;

        return queryFactory.selectFrom(user)
                .where(user.companyIdx.eq(companyIdx))
                .fetch();
    }

    @Override
    public Long updateCertification(Long userIdx) {
        QUser user = QUser.user;

        return queryFactory.update(user)
                .set(user.certification, true)
                .where(user.id.eq(userIdx))
                .execute();
    }


}
