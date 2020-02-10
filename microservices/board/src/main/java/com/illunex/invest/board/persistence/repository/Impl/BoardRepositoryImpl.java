package com.illunex.invest.board.persistence.repository.Impl;

import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.entity.QBoard;
import com.illunex.invest.board.persistence.repository.custom.BoardCustomRepository;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;


@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Board> findAllByBoardIdxAndSubjectContaining(Long boardIdx, String subject, Pageable pageable) {

        System.out.println("----custom function---");
        System.out.println(boardIdx);
        System.out.println(subject);
        System.out.println(pageable);

        QBoard board = QBoard.board;
        int offset = 0;
        if (pageable.getPageNumber() > 1) {
            offset = 10 * (pageable.getPageNumber() - 1);
        }

        QueryResults<Board> results;
        results = queryFactory.selectFrom(board)
                .where(board.boardIdx.eq(boardIdx).and(board.subject.contains(subject)))
                .limit(pageable.getPageSize())
                .offset(offset)
                .fetchResults();

        System.out.println(results);

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

}
