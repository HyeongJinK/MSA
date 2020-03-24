package com.illunex.invest.api.core.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInfoDTO {
    private Long id;
    private String username;
    private String name;
    private Set<RoleDTO> authorities = new HashSet<>();
    private String profileImg;
    private String vender;
    private Long companyIdx;
    private Boolean certification;
    private String token;
}
