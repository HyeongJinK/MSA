package com.illunex.invest.api.core.board.dto;

import lombok.*;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardListDTO {
    Page<BoardDTO> boardDTOS;
}