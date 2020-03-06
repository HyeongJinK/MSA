package com.illunex.invest.startup.controller.board;

import com.fasterxml.jackson.core.type.TypeReference;
import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.SignUpRequest;
import com.netflix.ribbon.proxy.annotation.Http;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/board")
public class BoardControllerImpl implements BoardController {
    Logger logger = LoggerFactory.getLogger(com.illunex.invest.startup.controller.board.BoardControllerImpl.class);

    private final RestTemplate restTemplate;
    private final WebClient.Builder loadBalanceWebClientBuilder;

    private final String boardUrl = "http://board";

    @GetMapping(value = "/notice")
    @Override
    public ResponseEntity<BoardDTO> getPost(Long boardIdx, Long postIdx) {
        System.out.println("------startup composite getPost-----");
        System.out.println("------boardIdx-----"+boardIdx);
        System.out.println("------postIdx-----"+postIdx);
        try {
            System.out.println("------try-----");
            ResponseEntity<BoardDTO> result = restTemplate.getForEntity(boardUrl + "/notice?boardIdx={boardIdx}&postIdx={postIdx}", BoardDTO.class, boardIdx, postIdx);
            System.out.println("-------result------"+ result);
            return result;
        } catch (RestClientException e) {
            System.out.println("------catch-----");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResponseEntity<Page<BoardDTO>> getPostList(Long boardIdx, String subject, Pageable pageable) {
//        try {
//            return restTemplate.getForEntity(boardUrl + "/notices?boardIdx={boardIdx}&subject={subject}&page={}&size={}", Page<BoardDTO>, boardIdx, subject, pageable.getPageNumber(), pageable.getPageSize());
//        } catch (RestClientException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public ResponseEntity<BoardDTO> addPost(BoardDTO boardDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        try {
            return restTemplate.postForEntity(boardUrl + "/notice", new HttpEntity(boardDto, headers), BoardDTO.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ResponseEntity<BoardDTO> updatePost(BoardDTO boardDto) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        try {
//            return restTemplate.put(boardUrl + "/notice", new HttpEntity(boardDto, headers));
//        } catch (RestClientException e) {
//            e.printStackTrace();
//        }

        return null;
    }

    @Override
    public ResponseEntity<String> deletePost(Long boardIdx, Long postIdx) {

        return null;
   }

}