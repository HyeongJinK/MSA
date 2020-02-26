package com.illunex.invest.api.core.user.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class JwtResponse {
    private final String jwtToken;
}
