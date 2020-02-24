package com.illunex.invest.board.controller;

import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDTO;
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

    @CrossOrigin("*")
    @GetMapping("/notices")
    @Override
    public ResponseEntity<Page<BoardDTO>> getPostList(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable) {
        Page<BoardDTO> postList = boardService.getPostList(boardIdx, subject, pageable);

        if (postList.getNumberOfElements() == 0){
            return new ResponseEntity("Post does not exist", HttpStatus.OK);
        } else {
            return new ResponseEntity(postList, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @GetMapping("/notice")
    @Override
    public ResponseEntity<BoardDTO> getPost(@RequestParam Long boardIdx, @RequestParam Long postIdx) {
        BoardDTO post = boardService.getPost(BoardDTO.builder().boardIdx(boardIdx).postIdx(postIdx).build());

        if (post == null) {
            return new ResponseEntity("Post does not exist", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(post, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PostMapping("/notice")
    @Override
    public ResponseEntity<BoardDTO> addPost(@RequestBody BoardDTO boardDto) {
        BoardDTO post = boardService.editPost(boardDto);

        if (post.getContent().equals("unavailable")) {
            return new ResponseEntity("Cannot add Post. Invalid PostIndex.", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity(post, HttpStatus.OK);
        }
    }

    @CrossOrigin("*")
    @PutMapping("/notice")
    @Override
    public ResponseEntity<BoardDTO> updatePost(@RequestBody BoardDTO boardDto) {
        BoardDTO post = boardService.editPost(boardDto);

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
        BoardDTO post = boardService.deletePost(boardIdx, postIdx);

        if (post == null) {
            return new ResponseEntity("Cannot delete Post", HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity("Post delete success", HttpStatus.OK);
        }
    }
}
