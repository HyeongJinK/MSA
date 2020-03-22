package com.illunex.invest.user.persistence.repository.Impl;

import com.illunex.invest.user.persistence.repository.custom.RoleCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleCustomRepositoryImpl implements RoleCustomRepository {
    private final JPAQueryFactory queryFactory;
}
