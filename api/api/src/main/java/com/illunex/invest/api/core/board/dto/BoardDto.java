package com.illunex.invest.api.core.board.dto;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class BoardDto {
    private Long postIdx;
    private Long boardIdx;
    private String subject;
    private Timestamp regDate;
    private String content;
}