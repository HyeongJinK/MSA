package com.illunex.invest.communication.persistence.alarm.repository.Impl;

import com.illunex.invest.communication.persistence.alarm.repository.custom.AlarmMessageCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AlarmMessageRepositoryImpl implements AlarmMessageCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public void deleteAllById(List<Long> ids) {

    }
}
