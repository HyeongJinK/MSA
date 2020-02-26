package com.illunex.invest.api.core.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {
    Long userIdx;
    String username;
    String password;
    String name;
    private String role;
    String profile;
    String vender;
}
