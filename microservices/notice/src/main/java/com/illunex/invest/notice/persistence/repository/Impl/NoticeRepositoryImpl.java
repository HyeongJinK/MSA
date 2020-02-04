package com.illunex.invest.notice.persistence.repository.Impl;

import com.illunex.invest.notice.persistence.entity.QNotice;
import com.illunex.invest.notice.persistence.repository.custom.NoticeCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 정의 리파지토리 클래
 * */
@RequiredArgsConstructor
public class NoticeRepositoryImpl implements NoticeCustomRepository {
    private JPAQueryFactory queryFactory;

    @Override
    public void templateFunc(Long idx) {
        /**
         * 템플릿 함수
         * */
        QNotice notice = QNotice.notice;

        queryFactory.selectFrom(notice)
                .where(notice.subject.eq("테스트0")
                    .and(notice.noticeIdx.eq(idx)))
                .orderBy(notice.noticeIdx.asc())
                .fetch();
    }
}
