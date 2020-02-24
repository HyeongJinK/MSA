package com.illunex.invest.board.service;

import com.illunex.invest.api.core.board.dto.BoardDTO;
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

    public Page<BoardDTO> getPostList(Long boardIdx, String subject, Pageable pageable) {
        Page<Board> postList = boardRepository.findAllByBoardIdxAndDeletedAndSubjectContainingOrderByPostIdxDesc(boardIdx, false, subject, pageable);
        Page<BoardDTO> postListDto = new PageImpl<>(BoardMapper.MAPPER.entityListToDtoList(postList.getContent()), postList.getPageable(), postList.getTotalElements());
        return postListDto;
    }

    public BoardDTO getPost(BoardDTO boardDto) {
        Board post = boardRepository.findByBoardIdxAndPostIdxAndDeleted(boardDto.getBoardIdx(), boardDto.getPostIdx(),false);
        BoardDTO postDto = BoardMapper.MAPPER.entityToDto(post);
        return postDto;
    }

    public BoardDTO editPost(BoardDTO boardDto) {
        if (boardDto.getPostIdx() != null) {
            if(boardRepository.findById(boardDto.getPostIdx()).isEmpty()){
                return BoardDTO.builder().content("unavailable").build();
            } else {
                if (boardRepository.findByBoardIdxAndPostIdx(boardDto.getBoardIdx(), boardDto.getPostIdx()).isDeleted()) {
                    return BoardDTO.builder().content("deleted").build();
                } else {
                    Board post = BoardMapper.MAPPER.dtoToEntity(boardDto);
                    post.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
                    boardRepository.save(post);
                    BoardDTO postDto = BoardMapper.MAPPER.entityToDto(post);
                    return postDto;
                }
            }
        } else {
            Board post = BoardMapper.MAPPER.dtoToEntity(boardDto);
            post.setRegDate(Timestamp.valueOf(LocalDateTime.now()));
            boardRepository.save(post);
            BoardDTO postDto = BoardMapper.MAPPER.entityToDto(post);
            return postDto;
        }
    }

    public BoardDTO deletePost(Long boardIdx, Long postIdx) {
        Board post = boardRepository.findByBoardIdxAndPostIdx(boardIdx, postIdx);
        post.setDeleted(true);
        boardRepository.save(post);
        BoardDTO postDto = BoardMapper.MAPPER.entityToDto(post);
        return postDto;
    }

}
