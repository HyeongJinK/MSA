package com.illunex.invest.api.core.board.dto;

import lombok.Data;
import java.sql.Timestamp;


@Data
public class BoardListDto {
    private Long postIdx;
    private Long boardIdx;
    private String subject;
    private Timestamp regDate;
    private String content;
    private Integer size;
    private Integer page;
}