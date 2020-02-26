package com.illunex.invest.board.service.mapper;

import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.board.persistence.entity.Board;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardMapper MAPPER = Mappers.getMapper( BoardMapper.class );

    BoardDTO entityToDto(Board board);
    Board dtoToEntity(BoardDTO boardDto);

    List<BoardDTO> entityListToDtoList(List<Board> boards);
    List<Board> dtoListToEntityList(List<BoardDTO> boardDTOS);
}