package com.illunex.invest.api.core.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtResponse {
    private String name;
    private String profileImg;
    private String jwtToken;
}
