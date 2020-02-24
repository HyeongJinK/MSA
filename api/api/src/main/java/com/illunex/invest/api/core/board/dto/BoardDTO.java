package com.illunex.invest.api.core.board.dto;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class BoardDTO {
    private Long postIdx;
    private Long boardIdx;
    private String subject;
    private Timestamp regDate;
    private String content;
}