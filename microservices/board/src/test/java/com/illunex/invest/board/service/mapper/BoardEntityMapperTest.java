package com.illunex.invest.board.service.mapper;


import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.board.persistence.entity.Board;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoardEntityMapperTest {
    private BoardMapper mapper = Mappers.getMapper(BoardMapper.class);

    @Test
    public void entryToDtoTest() {
        assertNotNull(mapper);

        Board board = Board.builder().boardIdx(1L).postIdx(1L).build();

        BoardDTO boardDto = mapper.entityToDto(board);

        assertEquals(board.getBoardIdx(), boardDto.getBoardIdx());
        assertEquals(board.getPostIdx(), boardDto.getPostIdx());
    }

    @Test
    public void dtoToEntityTest() {
        assertNotNull(mapper);

        BoardDTO boardDto = BoardDTO.builder().boardIdx(1L).postIdx(1L).build();

        Board board = mapper.dtoToEntity(boardDto);

        assertEquals(board.getBoardIdx(), boardDto.getBoardIdx());
        assertEquals(board.getPostIdx(), boardDto.getPostIdx());
    }
}

