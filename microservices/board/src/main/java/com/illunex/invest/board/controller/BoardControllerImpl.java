package com.illunex.invest.board.controller;

import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDto;
import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.service.BoardService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
public class BoardControllerImpl implements BoardController {
    private Log log = LogFactory.getLog(BoardControllerImpl.class);

    @Autowired
    BoardService boardService;

    @CrossOrigin("*")
    @GetMapping("/notice/list")
    @Override
    public ResponseEntity<Page<BoardDto>> getAllPost(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable) {
        System.out.println("---get All Post ---");
        System.out.println(boardIdx);
        System.out.println(subject);
        System.out.println(pageable);

        return new ResponseEntity(boardService.getAllPost(boardIdx, subject, pageable), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/notice/detail")
    @Override
    public ResponseEntity<BoardDto> getOnePost(@RequestBody BoardDto boardDto) {
        return new ResponseEntity(boardService.getOnePost(boardDto), HttpStatus.OK);
    }

    @CrossOrigin("*")
    @PostMapping("/notice/add")
    @Override
    public ResponseEntity<BoardDto> addPost(@RequestBody BoardDto boardDto) {
        BoardDto newBoard = boardService.addPost(boardDto);
        if (newBoard != null) {
            return new ResponseEntity(newBoard, HttpStatus.OK);
        } else {
            return new ResponseEntity("post add failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/notice/update")
    @Override
    public ResponseEntity<BoardDto> updatePost(@RequestBody BoardDto boardDto) {
        BoardDto updateBoard = boardService.addPost(boardDto);
        if (updateBoard != null) {
            return new ResponseEntity(updateBoard, HttpStatus.OK);
        } else {
            return new ResponseEntity("post update failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
