package com.illunex.invest.board.service;

import com.illunex.invest.board.mapper.BoardMapper;
import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import com.illunex.invest.api.core.board.dto.BoardDto;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Page<BoardDto> getAllPost(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable) {
        System.out.println("-----service----");
        System.out.println(boardIdx);
        System.out.println(subject);
        System.out.println(pageable);
        Page<Board> allPost = boardRepository.findAllByBoardIdxAndSubjectContaining(boardIdx, subject, pageable);
        System.out.println("-----allPost----");
        System.out.println(allPost.getContent());
        System.out.println(allPost.getTotalPages());
        System.out.println(allPost.getTotalElements());


        Page<BoardDto> allPost2 = new PageImpl<BoardDto>(BoardMapper.MAPPER.entityListToDtoList(allPost.getContent()), allPost.getPageable(), allPost.getTotalElements());
        //Page<BoardDto> allPostDto = BoardMapper.MAPPER.entityListToDtoList(allPost);
        return allPost2;
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
