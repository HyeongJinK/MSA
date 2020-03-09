package com.illunex.invest.api.core.board.dto;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long postIdx;
    private Long boardIdx;
    private String subject;
    private Timestamp regDate;
    private String content;
}