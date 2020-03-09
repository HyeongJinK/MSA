package com.illunex.invest.board.controller;

import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.api.core.board.dto.BoardListDTO;
import com.illunex.invest.board.service.BoardService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardControllerImpl implements BoardController {
    private Log log = LogFactory.getLog(BoardControllerImpl.class);

    final BoardService boardService;

    public BoardControllerImpl(BoardService boardService) {
        this.boardService = boardService;
    }

    @Override
    public ResponseEntity<BoardListDTO> getPostList(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable) {
        BoardListDTO postList = boardService.getPostList(boardIdx, subject, pageable);

        return new ResponseEntity(postList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BoardDTO> getPost(@RequestParam Long boardIdx, @RequestParam Long postIdx) {
        BoardDTO post = boardService.getPost(boardIdx, postIdx);

        return new ResponseEntity(post, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addPost(@RequestBody BoardDTO boardDto) {
        BoardDTO post = boardService.editPost(boardDto);

        if (post.getContent().equals("unavailable")) {
            return new ResponseEntity("Cannot add Post. Invalid PostIndex.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Post add success", HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> editPost(@RequestBody BoardDTO boardDto) {
        BoardDTO post = boardService.editPost(boardDto);

        if (post.getContent().equals("unavailable")) {
            return new ResponseEntity("Cannot update Post. Invalid PostIndex.", HttpStatus.OK);
        } else if (post.getContent().equals("deleted")) {
            return new ResponseEntity("Cannot update Post. Post already deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Post edit success", HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<String> deletePost(@RequestBody BoardDTO boardDto) {
        BoardDTO post = boardService.deletePost(boardDto.getBoardIdx(), boardDto.getPostIdx());

        if (post == null) {
            return new ResponseEntity("Cannot delete Post", HttpStatus.OK);
        } else {
            return new ResponseEntity("Post delete success", HttpStatus.OK);
        }
    }
}
