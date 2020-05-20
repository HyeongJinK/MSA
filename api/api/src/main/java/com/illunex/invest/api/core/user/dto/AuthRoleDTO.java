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
public class AuthRoleDTO {
    private Long id;
    protected Set<RoleDTO> authorities = new HashSet<>();
}
