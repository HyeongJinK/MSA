package com.illunex.invest.api.composite.startup.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberAuthorityEditDTO {
    Long userId;
    String userName;
    String userImg;

    @Getter @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class MemberRoleDTO {
        String RoleName;
        int detailedRight;
    }

    public void createMemberAuthorityEdit() {

    }
}
