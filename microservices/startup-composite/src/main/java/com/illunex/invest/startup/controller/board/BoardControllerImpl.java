package com.illunex.invest.startup.controller.board;

import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.api.common.response.HelperPage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
public class BoardControllerImpl implements BoardController {
    Logger logger = LoggerFactory.getLogger(com.illunex.invest.startup.controller.board.BoardControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String boardUrl = "http://board";

    @Override
    public ResponseEntity<BoardDTO> getPost(Long boardIdx, Long postIdx) {
        return restTemplate.getForEntity(boardUrl + "/board/notice?boardIdx={boardIdx}&postIdx={postIdx}", BoardDTO.class, boardIdx, postIdx);
    }

    @Override
    public ResponseEntity<Page<BoardDTO>> getPostList(Long boardIdx, String subject, Pageable pageable) {
        HelperPage<BoardDTO> data = restTemplate.getForObject(boardUrl + "/board/notices?boardIdx={boardIdx}&subject={subject}&page={page}&size={size}", HelperPage.class, boardIdx, subject, pageable.getPageNumber(), pageable.getPageSize());
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addPost(BoardDTO boardDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(boardUrl + "/board/notice/add", new HttpEntity(boardDto, headers), String.class);
    }

    @Override
    public ResponseEntity<String> editPost(BoardDTO boardDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(boardUrl + "/board/notice/edit", new HttpEntity(boardDto, headers), String.class);
    }

    @Override
    public ResponseEntity<String> deletePost(BoardDTO boardDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return restTemplate.postForEntity(boardUrl + "/board/notice/delete", new HttpEntity(boardDto, headers), String.class);
   }

}