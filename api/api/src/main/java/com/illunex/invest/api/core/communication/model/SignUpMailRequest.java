package com.illunex.invest.api.core.communication.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpMailRequest {
    String userName;
    String url;
}
