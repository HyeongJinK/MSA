package com.illunex.invest.user.persistence.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Sns {
    private String faceBook;
    private String twitter;
    private String instagram;
    private String linkdin;
    private String youtube;
}
