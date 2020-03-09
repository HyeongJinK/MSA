package com.illunex.invest.api.core.user.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Set<RoleDTO> roles = new HashSet<>();
    private String profileImg;
    private String vender;
    private Long companyIdx;
    private Boolean certification;
    private String token;
}
