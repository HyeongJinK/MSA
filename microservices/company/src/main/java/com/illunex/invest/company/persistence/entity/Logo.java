package com.illunex.invest.company.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Logo {
    @Column(updatable = false)
    String squareLogo;                // 로고
    @Column(updatable = false)
    String rectangleLogo;       // 직사각형 로고
}
