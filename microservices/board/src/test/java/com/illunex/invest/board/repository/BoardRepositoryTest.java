package com.illunex.invest.board.repository;

import com.illunex.invest.board.persistence.entity.Board;
import com.illunex.invest.board.persistence.repository.BoardRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:board"})
public class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Before
    public void setup() {
        List<Board> boardList = new ArrayList<Board>();
        for(int i = 0; i < 10; i++) {
            boardList.add(Board.builder().boardIdx(1L).postIdx((long) i+1).subject("test").content("test").deleted(false).build());
        }
        boardRepository.saveAll(boardList);
    }

    @Test
    public void findByBoardIdxAndPostIdx() {
        Board board = boardRepository.findByBoardIdxAndPostIdx(1L, 1L);

        Assert.assertEquals(board.getSubject(), "test");
        Assert.assertEquals(board.getContent(), "test");
    }

    @Test
    public void findByBoardIdxAndPostIdxAndDeleted() {
        Board board = boardRepository.findByBoardIdxAndPostIdxAndDeleted(1L, 1L, false);

        Assert.assertEquals(board.getSubject(), "test");
        Assert.assertEquals(board.getContent(), "test");
        Assert.assertFalse(board.isDeleted());
    }

    @Test
    public void findAllByBoardIdxAndDeletedAndSubjectContainingOrderByPostIdxDesc() {
        Pageable pageable = PageRequest.of(0, 10);

        Page<Board> board = boardRepository.findAllByBoardIdxAndDeletedAndSubjectContainingOrderByPostIdxDesc(1L, false,"test", pageable);

        Assert.assertEquals(board.getTotalElements(), 10);
        Assert.assertEquals(board.getTotalPages(), 1);
        Assert.assertEquals(board.getContent().get(1).getSubject(), "test");

    }
}
