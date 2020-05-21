package com.illunex.invest.api.core.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PluginRoleDTO {
    Long id;
    String roleTitle;
    String menuTitle;
    private int detailedRights;

    public boolean isRead() {
        return (this.detailedRights & 1) == 1;
    }

    public boolean isWrite() {
        return (this.detailedRights & 2) == 1;
    }

    public boolean isModify() {
        return (this.detailedRights & 4) == 1;
    }

    public boolean isDelete() {
        return (this.detailedRights & 8) == 1;
    }
}
