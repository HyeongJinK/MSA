package com.illunex.invest.api.core.user.model;

import com.illunex.invest.api.core.user.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityRequest {
    List<AuthorityItem> data = new ArrayList<>();

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuthorityItem {
        private Long id;
        private Set<RoleDTO> authorities = new HashSet<>();
    }
}
