package com.illunex.invest.api.core.board.dto;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long postIdx;
    private Long boardIdx;
    private String subject;
    private LocalDateTime regDate;
    private String content;
}