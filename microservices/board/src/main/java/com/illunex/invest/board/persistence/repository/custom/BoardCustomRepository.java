package com.illunex.invest.board.persistence.repository.custom;

import com.illunex.invest.api.core.board.dto.BoardDto;
import com.illunex.invest.board.persistence.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardCustomRepository {

    //Page<Board> findAllByBoardIdxAndSubjectContaining(Long boardIdx, String subject, Pageable pageable);

}
