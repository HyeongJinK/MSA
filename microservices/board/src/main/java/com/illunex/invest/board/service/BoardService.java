package com.illunex.invest.board.service;

import com.illunex.invest.api.core.board.dto.BoardDto;
import com.illunex.invest.board.service.mapper.BoardMapper;
import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Page<BoardDto> getAllPost(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable) {
        Page<Board> allPost = boardRepository.findAllByBoardIdxAndSubjectContainingOrderByPostIdxDesc(boardIdx, subject, pageable);

        Page<BoardDto> allPostDto = new PageImpl<BoardDto>(BoardMapper.MAPPER.entityListToDtoList(allPost.getContent()), allPost.getPageable(), allPost.getTotalElements());
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
