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
    @GetMapping("/notice/list")
    @Override
    public ResponseEntity<Page<BoardDto>> getAllPost(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable) {
        Page<BoardDto> allPost = boardService.getAllPost(boardIdx, subject, pageable);

        return new ResponseEntity(allPost, HttpStatus.OK);
//
//        if (allPost.getNumberOfElements() == 0){
//            return new ResponseEntity("Post does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
//        } else {
//            return new ResponseEntity(allPost, HttpStatus.OK);
//        }
    }

    @CrossOrigin("*")
    @PostMapping("/notice/detail")
    @Override
    public ResponseEntity<BoardDto> getOnePost(@RequestBody BoardDto boardDto) {
        BoardDto post = boardService.getOnePost(boardDto);

        if (post == null) {
            return new ResponseEntity("Post does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(boardService.getOnePost(boardDto), HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/notice/add")
    @Override
    public ResponseEntity<BoardDto> addPost(@RequestBody BoardDto boardDto) {
        return new ResponseEntity(boardService.addPost(boardDto), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/notice/update")
    @Override
    public ResponseEntity<BoardDto> updatePost(@RequestBody BoardDto boardDto) {
        return new ResponseEntity(boardService.addPost(boardDto), HttpStatus.OK);
    }
}
