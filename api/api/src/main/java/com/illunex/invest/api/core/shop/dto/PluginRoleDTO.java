package com.illunex.invest.api.core.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PluginRoleDTO {
    Long id;
    String roleTitle;
    String menuTitle;
    private int detailedRights;

    public String getName() {
        return roleTitle;
    }

    public boolean isRead() {
        return (this.detailedRights & 1) == 1;
    }

    public boolean isWrite() {
        return (this.detailedRights & 2) == 2;
    }

    public boolean isModify() {
        return (this.detailedRights & 4) == 4;
    }

    public boolean isDelete() {
        return (this.detailedRights & 8) == 8;
    }
}
