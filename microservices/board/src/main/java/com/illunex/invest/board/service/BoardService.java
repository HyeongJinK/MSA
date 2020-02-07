package com.illunex.invest.board.service;

import com.illunex.invest.board.mapper.BoardMapper;
import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.illunex.invest.api.core.board.dto.BoardDto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<BoardDto> getAllPost() {
        List<Board> allPost = boardRepository.findAll();
        List<BoardDto> allPostDto = BoardMapper.MAPPER.entityListToDtoList(allPost);
        return allPostDto;
    }

    public BoardDto getOnePost(BoardDto boardDto) {
        Board post = boardRepository.findByPostIdxAndBoardIdx(boardDto.getPostIdx(), boardDto.getBoardIdx());
        BoardDto postDto = BoardMapper.MAPPER.entityToDto(post);
        return postDto;
    }

    public BoardDto addPost(BoardDto boardDto) {
        Board newBoard = BoardMapper.MAPPER.dtoToEntity(boardDto);
        newBoard.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
        boardRepository.save(newBoard);
        BoardDto newBoardDto = BoardMapper.MAPPER.entityToDto(newBoard);
        return newBoardDto;
    }
}
