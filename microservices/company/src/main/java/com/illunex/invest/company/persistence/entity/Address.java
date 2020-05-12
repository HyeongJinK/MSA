package com.illunex.invest.company.persistence.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    String zipCode;             // 우편번호
    String address;             // 주소
    String addressDetail;       // 상세주소
}
