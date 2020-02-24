package com.illunex.invest.board.controller;

import com.illunex.invest.api.core.board.controller.BoardController;
import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.service.BoardService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:board"})
public class BoardControllerTest {
    WebTestClient webTestClient;

    @MockBean
    BoardService boardService;

    @Autowired
    BoardController boardController;

    @Before
    public void setup() {
        BoardDTO request = BoardDTO.builder().boardIdx(1L).postIdx(1L).build();
        BoardDTO response = BoardDTO.builder().boardIdx(1L).postIdx(1L).subject("test").content("test").build();

        List<Board> boardList = new ArrayList<Board>();
        for(int i = 0; i < 10; i++) {
            boardList.add(Board.builder().boardIdx(1L).postIdx((long) i+1).subject("test").content("test").deleted(false).build());
        }

        Pageable pageable = PageRequest.of(0, 10);
        Page<BoardDTO> boardDto = new PageImpl(boardList,pageable,10);

        when(boardService.getPost(request))
                .thenReturn(response);
        when(boardService.getPostList(1L, "test", pageable))
                .thenReturn(boardDto);

        webTestClient = WebTestClient.bindToController(new BoardControllerImpl(boardService))
                .configureClient()
                .baseUrl("")
                .build();
    }

    @Test
    public void getPostListTest() {
        Pageable pageable = PageRequest.of(0, 10);
        ResponseEntity<Page<BoardDTO>> result = boardController.getPostList(1L, "test", pageable);

        Assert.assertEquals(result.getBody().getTotalElements(), 10);
        Assert.assertEquals(result.getBody().getTotalPages(), 1);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }


//    @Test
//    public void getPostListHttpTest() throws Exception {
//        webTestClient.get()
//                .uri("/notices?boardIdx=1&subject=&page=1&size=10")
//                .accept(APPLICATION_JSON_UTF8)
//                .exchange()
//                .expectStatus().isEqualTo(HttpStatus.OK)
//                .expectHeader().contentType(APPLICATION_JSON_UTF8)
//                .expectBody()
//                .jsonPath("TotalElements").isEqualTo("10")
//                .jsonPath("TotalPages").isEqualTo("1");
//    }


    @Test
    public void getPostTest() {
        ResponseEntity<BoardDTO> result = boardController.getPost(1L,1L);

        Assert.assertEquals(result.getBody().getPostIdx().longValue(), 1L);
        Assert.assertEquals(result.getBody().getBoardIdx().longValue(), 1L);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void getPostHttpTest() throws Exception {
        webTestClient.get()
                .uri("/notice?boardIdx=1&postIdx=1")
                .accept(APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectHeader().contentType(APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("postIdx").isEqualTo("1")
                .jsonPath("content").isEqualTo("test");
    }

}