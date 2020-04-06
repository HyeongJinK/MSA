package com.illunex.invest.api.composite.startup.menu.dto;

import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.user.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
class Menu {
    private String title;
    private String id;
    private String icon;
    private String to;
    private List<Menu> subMenu = new ArrayList<>();


    private void makeMainMenu(List<Menu> myPageMenu, String title, String id, String icon, List<Menu> subMenus) {
        myPageMenu.add(Menu.builder()
                .title(title)
                .id(id)
                .icon(icon)
                .subMenu(subMenus)
                .build());
    }

    private Menu makeSubMenu(String title, String id, String to) {
        return Menu.builder()
                .title(title)
                .id(id)
                .to(to)
                .build();
    }

    private List<Menu> initDashBoardSubMenu(Set<RoleDTO> roles) {
        return List.of(makeSubMenu("대시보드", "main", "/dashboard/main"));
    }

    private List<Menu> initAlarmSubMenu(Set<RoleDTO> roles) {
        return List.of(Menu.builder().build());
    }

    private List<Menu> initAccountSubMenu(Set<RoleDTO> roles) {
        List<Menu> accountSubMenu = List.of(makeSubMenu("비밀번호 변경", "myPage", "/myPage/password"));

        roles.stream()
                .filter(role -> role.getName().equals("ROLE_COMPANY_ADMIN"))
                .forEach(role -> {
                    accountSubMenu.add(makeSubMenu("권한설정", "permission", "/myPage/permission"));
                    accountSubMenu.add(makeSubMenu("서명관리", "signature", "/myPage/signature"));
                });

        return accountSubMenu;
    }

    private List<Menu> initPluginSubMenu(Set<RoleDTO> roles) {
        return List.of(makeSubMenu("전체 플러그인", "plugin", "/myPage/plugin"));
    }

    private List<Menu> initLicenseSubMenu(Set<RoleDTO> roles) {
        return List.of(makeSubMenu("결제", "license", "/myPage/license"),
                makeSubMenu("고객센터", "support", "/myPage/license/cs"));
    }

    private List<Menu> initMainMenu(Set<RoleDTO> roles, List<IRDTO> irList) {
        List<Menu> mainMenu = makeDefaultMainMenu(roles);

        List<Menu> companySubMenu = makeCompanySubMenu(roles, irList);

        if (companySubMenu != null) {
            makeMainMenu(mainMenu, "기업", "commpany", "company", companySubMenu);
        }


        roles.stream()
                .forEach(role -> {
                    switch (role.getName()) {
                        case "ROLE_FEED":
                            makeMainMenu(mainMenu, "피드", "feed", "feed", List.of(
                                    makeSubMenu("피드", "feed", "/feed")
                            ));
                            break;
                        case "ROLE_NEWS" :
                            makeMainMenu(mainMenu, "피드", "feed", "feed", List.of(
                                    makeSubMenu("뉴스", "news", "/news")
                            ));
                            break;
                    }
                });
        return mainMenu;
    }

    @NotNull
    private List<Menu> makeCompanySubMenu(Set<RoleDTO> roles, List<IRDTO> irList) {
        return roles.stream()
                    .filter(role -> (role.getName().equals("ROLE_COMPANY") && role.isRead())
                            || (role.getName().equals("ROLE_PRODUCT")  && role.isRead())
                            || (role.getName().equals("ROLE_TEAM")  && role.isRead())
                            || (role.getName().equals("ROLE_SHAREHOLDER")  && role.isRead()))
                    .map(role -> {
                        switch (role.getName()) {
                            case "ROLE_COMPANY":
                                return makeSubMenu("기업정보", "info", "/company/info");
                            case "ROLE_PRODUCT":
                                return makeSubMenu("제품정보", "product", "/company/product");
                            case "ROLE_TEAM":
                                return makeSubMenu("팀정보", "member", "/company/member");
                            case "ROLE_SHAREHOLDER":
                                return makeSubMenu("주주정보", "shareholder", "/company/shareholder");
                            default:
                                return null;
                        }
                    })
                    .collect(Collectors.toList());
    }

    @NotNull
    private List<Menu> makeDefaultMainMenu(Set<RoleDTO> roles) {
        return List.of(Menu.builder()
                    .title("대시보드")
                    .id("dashboard")
                    .icon("dashboard")
                    .subMenu(initDashBoardSubMenu(roles))
                    .build());
    }

    /**
     * MyPageMenu
     * */
    private List<Menu> initMyPageMenu(Set<RoleDTO> roles) {
        List<Menu> myPageMenu = makeDefaultMyPageMenu(roles);

        roles.stream()
                .forEach((role -> {
                    switch (role.getName()) {
                        case "ROLE_COMPANY_ADMIN":
                            makeMainMenu(myPageMenu, "플러그인", "plugin", "plugin", initPluginSubMenu(roles));
                            makeMainMenu(myPageMenu, "라이센스", "license", "license", initLicenseSubMenu(roles));
                            break;
                    }
                }));
        return myPageMenu;
    }

    @NotNull
    private List<Menu> makeDefaultMyPageMenu(Set<RoleDTO> roles) {
        return List.of(Menu.builder()
                            .title("계정설정")
                            .id("myPage")
                            .icon("myPage")
                            .subMenu(initAccountSubMenu(roles))
                            .build()
                    , Menu.builder()
                            .title("알람")
                            .id("alarm")
                            .icon("alarm")
                            .subMenu(initAlarmSubMenu(roles))
                            .build());
    }


//    private void init(Set<RoleDTO> roles) {
//        list.addAll(initMainMenu(roles));
//        myPage.addAll(initMyPageMenu(roles));
//    }
}
