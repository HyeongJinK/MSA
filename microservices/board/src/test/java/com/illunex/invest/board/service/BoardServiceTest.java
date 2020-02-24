package com.illunex.invest.board.service;

import com.illunex.invest.api.core.board.dto.BoardDTO;
import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.BoardRepository;
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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false"
        , "spring.cloud.config.enabled=false"
        , "spring.datasource.url=jdbc:h2:mem:board"})
public class BoardServiceTest {
    @MockBean
    BoardRepository boardRepository;
    @Autowired BoardService boardService;

    @Before
    public void setup() {
        List<Board> boardList = new ArrayList<Board>();
        for(int i = 0; i < 10; i++) {
            boardList.add(Board.builder().boardIdx(1L).postIdx((long) i+1).subject("test").content("test").deleted(false).build());
        }
        boardRepository.saveAll(boardList);

        Pageable pageable = PageRequest.of(0, 10);
        Page<Board> board = new PageImpl<>(boardList,pageable,10);
        Page<Board> board2 = new PageImpl<>(new ArrayList<>(), pageable, 0);

        when(boardRepository.findByBoardIdxAndPostIdxAndDeleted(1L,1L, false))
                .thenReturn(boardList.get(0));
        when(boardRepository.findByBoardIdxAndPostIdxAndDeleted(1L,11L, false))
                .thenReturn(new Board());
        when(boardRepository.findAllByBoardIdxAndDeletedAndSubjectContainingOrderByPostIdxDesc(1L, false, "test", pageable))
                .thenReturn(board);
        when(boardRepository.findAllByBoardIdxAndDeletedAndSubjectContainingOrderByPostIdxDesc(1L, false, "null", pageable))
                .thenReturn(board2);
        when(boardRepository.findById(1L))
                .thenReturn(Optional.of(boardList.get(0)));
        when(boardRepository.findByBoardIdxAndPostIdx(1L, 1L))
                .thenReturn(boardList.get(0));
    }

    @Test
    public void getPostListTest() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<BoardDTO> boardDto = boardService.getPostList(1L, "test", pageable);

        Assert.assertEquals(boardDto.getTotalElements(), 10);
        Assert.assertEquals(boardDto.getTotalPages(), 1);
        Assert.assertEquals(boardDto.getContent().get(1).getSubject(), "test");
        Assert.assertEquals(boardDto.getContent().get(1).getContent(), "test");
    }

    @Test
    public void getPostListNullTest() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<BoardDTO> boardDto = boardService.getPostList(1L, "null", pageable);

        Assert.assertEquals(boardDto.getTotalElements(), 0);
        Assert.assertEquals(boardDto.getTotalPages(), 0);
        Assert.assertTrue(boardDto.getContent().isEmpty());
    }

    @Test
    public void getPostTest() {
        BoardDTO post = BoardDTO.builder().boardIdx(1L).postIdx(1L).build();
        BoardDTO boardDto = boardService.getPost(post);
        Assert.assertEquals(boardDto.getSubject(), "test");
        Assert.assertEquals(boardDto.getContent(), "test");
    }

    @Test
    public void getPostNullTest() {
        BoardDTO post = BoardDTO.builder().boardIdx(1L).postIdx(11L).build();
        BoardDTO boardDto = boardService.getPost(post);
        Assert.assertNull(boardDto.getContent());
    }

    @Test
    public void addPostTest() {
        BoardDTO post = BoardDTO.builder().boardIdx(1L).content("test").build();
        BoardDTO boardDto = boardService.editPost(post);
        Assert.assertEquals(boardDto.getContent(), "test");
    }

    @Test
    public void updatePostTest() {
        BoardDTO post = BoardDTO.builder().boardIdx(1L).postIdx(1L).content("updated post").build();
        BoardDTO boardDto = boardService.editPost(post);
        Assert.assertEquals(boardDto.getContent(), "updated post");
    }

    @Test
    public void deletePostTest() {
        boardService.deletePost(1L, 1L);
        Assert.assertTrue(boardRepository.findByBoardIdxAndPostIdx(1L, 1L).isDeleted());
    }
}
