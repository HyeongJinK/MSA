package com.illunex.invest.api.core.communication.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MultiFileDeleteDTO {
    String bucket;     // 버킷 이름
    String[] keys;     // 파일 key 목록
}
