package com.illunex.invest.board.persistence.repository.Impl;

import com.illunex.invest.board.persistence.entity.QBoard;
import com.illunex.invest.board.persistence.repository.custom.BoardCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 정의 리파지토리 클래
 * */
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardCustomRepository {
    private JPAQueryFactory queryFactory;

    @Override
    public void templateFunc(Long idx) {
        /**
         * 템플릿 함수
         * */
        QBoard board = QBoard.board;

        queryFactory.selectFrom(board)
                .where(board.subject.eq("테스트0")
                    .and(board.postIdx.eq(idx)))
                .orderBy(board.postIdx.asc())
                .fetch();
    }
}
