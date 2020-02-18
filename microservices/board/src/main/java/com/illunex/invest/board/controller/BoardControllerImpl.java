package com.illunex.invest.board.controller;

import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDto;
import com.illunex.invest.board.service.BoardService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardControllerImpl implements BoardController {
    private Log log = LogFactory.getLog(BoardControllerImpl.class);

    @Autowired
    BoardService boardService;

    @CrossOrigin("*")
    @GetMapping("/notices")
    @Override
    public ResponseEntity<Page<BoardDto>> getPostList(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable) {
        Page<BoardDto> postList = boardService.getPostList(boardIdx, subject, pageable);

        if (postList.getNumberOfElements() == 0){
            return new ResponseEntity("Post does not exist", HttpStatus.OK);
        } else {
            return new ResponseEntity(postList, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @GetMapping("/notice")
    @Override
    public ResponseEntity<BoardDto> getPost(@RequestParam Long boardIdx, @RequestParam Long postIdx) {
        BoardDto boardDto = new BoardDto();
        boardDto.setBoardIdx(boardIdx);
        boardDto.setPostIdx(postIdx);

        BoardDto post = boardService.getPost(boardDto);

        if (post == null) {
            return new ResponseEntity("Post does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(post, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/notice")
    @Override
    public ResponseEntity<BoardDto> addPost(@RequestBody BoardDto boardDto) {
        BoardDto post = boardService.editPost(boardDto);

        if (post.getContent().equals("unavailable")) {
            return new ResponseEntity("Cannot add Post. Invalid PostIndex.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(post, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PutMapping("/notice")
    @Override
    public ResponseEntity<BoardDto> updatePost(@RequestBody BoardDto boardDto) {
        BoardDto post = boardService.editPost(boardDto);

        if (post.getContent().equals("unavailable")) {
            return new ResponseEntity("Cannot update Post. Invalid PostIndex.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else if (post.getContent().equals("deleted")) {
            return new ResponseEntity("Cannot update Post. Post already deleted.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(post, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @DeleteMapping("/notice")
    @Override
    public ResponseEntity<String> deletePost(@RequestParam Long boardIdx, @RequestParam Long postIdx) {
        BoardDto post = boardService.deletePost(boardIdx, postIdx);

        if (post == null) {
            return new ResponseEntity("Cannot delete Post", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity("Post delete success", HttpStatus.OK);
        }
    }
}
