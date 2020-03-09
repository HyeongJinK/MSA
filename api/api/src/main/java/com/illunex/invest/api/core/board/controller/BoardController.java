package com.illunex.invest.api.core.board.controller;

import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.api.core.board.dto.BoardListDTO;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@Api(produces = "produces Value")
@RequestMapping(value = "/board")
public interface BoardController {
//    @ApiOperation(value = "a1331"
//            , notes = "Notes Test"
//            , response = BoardController.class
//            , responseContainer = "ResponseContainer Test"
//            , produces = "Produces Test")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Success"),
//            @ApiResponse(code = 400, message = "Bad Request")
//    })

    @GetMapping(value = "/notice")
    ResponseEntity<BoardDTO> getPost(@RequestParam Long boardIdx, @RequestParam Long postIdx);
    @GetMapping(value = "/notices")
    ResponseEntity<BoardListDTO> getPostList(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable);
    @PostMapping(value = "/notice/add")
    ResponseEntity<String> addPost(@RequestBody BoardDTO boardDto);
    @PostMapping(value = "/notice/edit")
    ResponseEntity<String> editPost(@RequestBody BoardDTO boardDto);
    @PostMapping(value = "/notice/delete")
    ResponseEntity<String> deletePost(@RequestBody BoardDTO boardDto);

}
