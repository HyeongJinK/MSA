package com.illunex.invest.api.core.board.controller;

import com.illunex.invest.api.core.board.dto.BoardDTO;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;

@Api(produces = "produces Value")
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

    ResponseEntity<BoardDTO> getPost(@RequestParam Long boardIdx, @RequestParam Long postIdx);

    ResponseEntity<Page<BoardDTO>> getPostList(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable);

    ResponseEntity<BoardDTO> addPost(@RequestBody BoardDTO boardDto);

    ResponseEntity<BoardDTO> updatePost(@RequestBody BoardDTO boardDto);

    ResponseEntity<String> deletePost(@RequestParam Long boardIdx, @RequestParam Long postIdx);

}
