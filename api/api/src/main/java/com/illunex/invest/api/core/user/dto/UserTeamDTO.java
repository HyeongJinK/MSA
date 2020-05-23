package com.illunex.invest.api.core.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserTeamDTO {
    private Long id;
    private String username;
    private String name;
    private Set<RoleDTO> authorities = new HashSet<>();
    private Boolean certification;

    public boolean isAdmin() {
        return authorities.stream().filter(auth -> auth.getName().equals("ROLE_COMPANY_ADMIN")).count() == 1l;
    }
}
