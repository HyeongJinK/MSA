package com.illunex.invest.communication.persistence.alarm.repository.Impl;

import com.illunex.invest.communication.persistence.alarm.repository.custom.AlarmReceiveCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AlarmReceiveRepositoryImpl implements AlarmReceiveCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public void readAll(Long userId) {

    }
}
