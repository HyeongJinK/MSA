package com.illunex.invest.api.core.board.controller;

import com.illunex.invest.api.core.board.dto.BoardDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.data.domain.Pageable;
import java.util.List;

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

    public ResponseEntity<BoardDto> getPost(@RequestParam Long boardIdx, @RequestParam Long postIdx);

    public ResponseEntity<Page<BoardDto>> getPostList(@RequestParam Long boardIdx, @RequestParam String subject, Pageable pageable);

    public ResponseEntity<BoardDto> addPost(@RequestBody BoardDto boardDto);

    public ResponseEntity<BoardDto> updatePost(@RequestBody BoardDto boardDto);

    public ResponseEntity<String> deletePost(@RequestParam Long boardIdx, @RequestParam Long postIdx);

}
