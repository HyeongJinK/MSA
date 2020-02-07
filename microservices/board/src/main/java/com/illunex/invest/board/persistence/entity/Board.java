package com.illunex.invest.board.persistence.entity;

import lombok.*;
import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long postIdx;              // ID
    Long boardIdx;
    String subject;              // 제목
    Timestamp regDate;           // 등록일

    @Column(name="content", columnDefinition = "text COMMENT '내용'")
    String content;              // 내용

    @Builder
    public Board(Long postIdx, Long boardIdx, String subject, Timestamp regDate, String content){
        this.postIdx = postIdx;
        this.boardIdx = boardIdx;
        this.subject = subject;
        this.regDate = regDate;
        this.content = content;
    }
}
