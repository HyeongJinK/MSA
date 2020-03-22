package com.illunex.invest.api.composite.startup.mypage.dto;

import com.illunex.invest.api.core.user.dto.AuthorityDTO;
import com.illunex.invest.api.core.user.dto.RoleDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
public class AuthorityExDTO extends AuthorityDTO {
    public boolean isCompanyAdmin() {
        return authorities.stream()
                .filter(item -> item.getName().equals("ROLE_COMPANY_ADMIN"))
                .count() == 1L;
    }

    public List<RoleDTO> getSortList() {
        List<RoleDTO> list = new ArrayList<RoleDTO>(authorities);
        return list.stream()
                .filter(roleDTO -> !(roleDTO.getName().equals("ROLE_COMPANY_ADMIN") || roleDTO.getName().equals("ROLE_USER")))
                .sorted(Comparator.comparing(RoleDTO::getName))
                .collect(Collectors.toList());
    }
}
