package com.illunex.invest.board.persistence.repository;

import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.custom.BoardCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
    Board findByPostIdxAndBoardIdx(Long postIdx, Long boardIdx);
    Board findByPostIdx(Long postIdx);
}
