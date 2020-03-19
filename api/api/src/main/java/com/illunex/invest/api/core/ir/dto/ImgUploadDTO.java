package com.illunex.invest.api.core.ir.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImgUploadDTO {
    Long idx;             // member index
    MultipartFile img;    // img file
}
