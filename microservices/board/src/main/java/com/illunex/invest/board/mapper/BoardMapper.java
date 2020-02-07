package com.illunex.invest.board.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.illunex.invest.api.core.board.dto.BoardDto;
import com.illunex.invest.board.persistence.entity.Board;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    BoardMapper MAPPER = Mappers.getMapper( BoardMapper.class );

    BoardDto entityToDto(Board board);
    Board dtoToEntity(BoardDto boardDto);

    List<BoardDto> entityListToDtoList(List<Board> boards);
    List<Board> dtoListToEntityList(List<BoardDto> BoardDto);
}