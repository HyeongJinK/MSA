package com.illunex.invest.communication.persistence.alarm.repository.Impl;

import com.illunex.invest.communication.persistence.alarm.repository.custom.AlarmReceiveRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlarmReceiveRepositoryImpl implements AlarmReceiveRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    @Override
    public void readAll(Long userId) {

    }
}
