package com.illunex.invest.api.core.user.dto;

import com.illunex.invest.api.core.user.model.RoleInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class RoleDTO implements RoleInterface {
    private Long id;
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
