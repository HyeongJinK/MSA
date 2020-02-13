package com.illunex.invest.board.service;

import com.illunex.invest.api.core.board.dto.BoardDto;
import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.BoardRepository;
import com.illunex.invest.board.service.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public Page<BoardDto> getPostList(Long boardIdx, String subject, Pageable pageable) {
        Page<Board> postList = boardRepository.findAllByBoardIdxAndDeletedAndSubjectContainingOrderByPostIdxDesc(boardIdx, false, subject, pageable);
        Page<BoardDto> postListDto = new PageImpl<>(BoardMapper.MAPPER.entityListToDtoList(postList.getContent()), postList.getPageable(), postList.getTotalElements());
        return postListDto;
    }

    public BoardDto getPost(BoardDto boardDto) {
        Board post = boardRepository.findByBoardIdxAndPostIdxAndDeleted(boardDto.getBoardIdx(), boardDto.getPostIdx(),false);
        BoardDto postDto = BoardMapper.MAPPER.entityToDto(post);
        return postDto;
    }

    public BoardDto editPost(BoardDto boardDto) {
        if (boardDto.getPostIdx() != null) {
            if(boardRepository.findById(boardDto.getPostIdx()).isEmpty()){
                BoardDto emptyPostDto = new BoardDto();
                emptyPostDto.setContent("unavailable");
                return emptyPostDto;
            } else {
                if (boardRepository.findByBoardIdxAndPostIdx(boardDto.getBoardIdx(), boardDto.getPostIdx()).isDeleted()) {
                    BoardDto emptyPostDto = new BoardDto();
                    emptyPostDto.setContent("deleted");
                    return emptyPostDto;
                } else {
                    Board post = BoardMapper.MAPPER.dtoToEntity(boardDto);
                    post.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
                    boardRepository.save(post);
                    BoardDto postDto = BoardMapper.MAPPER.entityToDto(post);
                    return postDto;
                }
            }
        } else {
            Board post = BoardMapper.MAPPER.dtoToEntity(boardDto);
            post.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
            boardRepository.save(post);
            BoardDto postDto = BoardMapper.MAPPER.entityToDto(post);
            return postDto;
        }
    }

    public BoardDto deletePost(Long boardIdx, Long postIdx) {
        Board post = boardRepository.findByBoardIdxAndPostIdx(boardIdx, postIdx);
        post.setDeleted(true);
        boardRepository.save(post);
        BoardDto postDto = BoardMapper.MAPPER.entityToDto(post);
        return postDto;
    }

}
