package com.illunex.invest.api.core.board.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
public class BoardDTO {
    private Long postIdx;
    private Long boardIdx;
    private String subject;
    private Timestamp regDate;
    private String content;
}