package com.illunex.invest.user.persistence.repository.Impl;

import com.illunex.invest.user.persistence.entity.QUser;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.custom.UserCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {
    private final JPAQueryFactory queryFactory;
    @Override
    public List<User> findByCompanyIdx(Long companyIdx) {
        QUser user = QUser.user;

        return queryFactory.selectFrom(user)
                .where(user.companyIdx.eq(companyIdx))
                .fetch();
    }

//    @Override
//    public User updateAuthority(Long id, Set<Role> authorities) {
//        QUser user = QUser.user;
//
//        queryFactory.update(user).where(user.id.eq(id))
//                .set(user.authorities, authorities)
//                .execute();
//
//        return null;
//    }
}
