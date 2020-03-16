package com.illunex.invest.api.core.user.dto;

import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SignatureDTO {
    Long id;
    String imgUrl;
    SignatureStatus status;
    LocalDateTime updateDate;
}
