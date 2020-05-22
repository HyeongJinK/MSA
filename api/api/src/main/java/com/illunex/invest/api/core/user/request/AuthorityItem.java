package com.illunex.invest.api.core.user.request;

import com.illunex.invest.api.core.user.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityItem {
    private Long id;
    private Set<RoleDTO> pluginRole = new HashSet<>();
}
