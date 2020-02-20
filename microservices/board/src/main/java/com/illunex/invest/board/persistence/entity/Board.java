package com.illunex.invest.board.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long postIdx;           // ID
    Long boardIdx;          // 게시판 구분
    String subject;         // 제목
    String content;         // 내용
    Timestamp regDate;      // 등록일
    boolean deleted;        // 삭제여부

    @Builder
    public Board(Long postIdx, Long boardIdx, String subject, String content, Timestamp regDate, boolean deleted){
        this.postIdx = postIdx;
        this.boardIdx = boardIdx;
        this.subject = subject;
        this.content = content;
        this.regDate = regDate;
        this.deleted = deleted;
    }

}
