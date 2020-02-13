package com.illunex.invest.board.persistence.repository;

import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.custom.BoardCustomRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
    Board findByBoardIdxAndPostIdx(Long boardIdx, Long postIdx);
    Board findByBoardIdxAndPostIdxAndDeleted(Long boardIdx, Long postIdx, Boolean deleted);
    Page<Board> findAllByBoardIdxAndDeletedAndSubjectContainingOrderByPostIdxDesc(Long boardIdx, Boolean deleted, String subject, Pageable pageable);
}
