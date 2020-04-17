package com.illunex.invest.api.composite.startup.menu.dto;

import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.user.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MenuDto {
    private List<Menu> main = new ArrayList<>();
    private List<Menu> myPage = new ArrayList<>();

    public MenuDto(Collection<RoleDTO> roles, List<IRDTO> irList) {
        initMainMenu(roles, irList);
        initMyPageMenu(roles);
    }

    private void makeMainMenu(String title, String id, String icon, List<Menu> subMenus) {
        main.add(Menu.builder()
                .title(title)
                .id(id)
                .icon(icon)
                .subMenu(subMenus)
                .build());
    }

    private void makeMyPageMenu(String title, String id, String icon, List<Menu> subMenus) {
        myPage.add(Menu.builder()
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

    private List<Menu> initDashBoardSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("대시보드", "main", "/dashboard/main"));
    }

    private List<Menu> initAlarmSubMenu(Collection<RoleDTO> roles) {
        return List.of(Menu.builder().build());
    }

    private List<Menu> initAccountSubMenu(Collection<RoleDTO> roles) {
        List<Menu> accountSubMenu = new ArrayList<>();
        accountSubMenu.add(makeSubMenu("비밀번호 변경", "myPage", "/myPage/password"));

        roles.stream()
                .filter(role -> role.getName().equals("ROLE_COMPANY_ADMIN"))
                .forEach(role -> {
                    accountSubMenu.add(makeSubMenu("권한설정", "permission", "/myPage/permission"));
                    accountSubMenu.add(makeSubMenu("서명관리", "signature", "/myPage/signature"));
                });

        return accountSubMenu;
    }

    private List<Menu> initPluginSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("전체 플러그인", "plugin", "/myPage/plugin"));
    }

    private List<Menu> initLicenseSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("결제", "license", "/myPage/license"),
                makeSubMenu("고객센터", "support", "/myPage/license/cs"));
    }



    @NotNull
    private List<Menu> makeCompanySubMenu(Collection<RoleDTO> roles) {
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

    private List<Menu> makeIrSubMenu(RoleDTO role, List<IRDTO> irList) {
        List<Menu> subMenu = new ArrayList<>();
        subMenu.add(makeSubMenu("All", "list", "/ir/list"));
        subMenu.addAll(irList.stream()
                .map(ir -> makeSubMenu(ir.getYear(),ir.getYear(), "/ir/"+ir.getYear()))
                .collect(Collectors.toList()));
        return subMenu;
    }

    @NotNull
    private void makeDefaultMainMenu(Collection<RoleDTO> roles) {
        main.add(Menu.builder()
                .title("대시보드")
                .id("dashboard")
                .icon("dashboard")
                .subMenu(initDashBoardSubMenu(roles))
                .build());
    }


    @NotNull
    private void makeDefaultMyPageMenu(Collection<RoleDTO> roles) {
        myPage.add(Menu.builder()
                .title("계정설정")
                .id("myPage")
                .icon("myPage")
                .subMenu(initAccountSubMenu(roles))
                .build());
        myPage.add(Menu.builder()
                .title("알람")
                .id("alarm")
                .icon("alarm")
                .subMenu(initAlarmSubMenu(roles))
                .build());
    }

    private void initMainMenu(Collection<RoleDTO> roles, List<IRDTO> irList) {
        boolean companyMenu = true;
        makeDefaultMainMenu(roles);

        if (main != null) {
            makeMainMenu("기업", "commpany", "company", makeCompanySubMenu(roles));
        }

        roles.stream()
                .forEach(role -> {
                    switch (role.getName()) {
                        case "ROLE_COMPANY":
                            makeMainMenu("기업", "commpany", "company", makeCompanySubMenu(roles));
                            break;
                        case "ROLE_IR":
                            makeMainMenu("IR 작성", "ir", "ir", makeIrSubMenu(role, irList));
                            break;
                        case "ROLE_FEED":
                            makeMainMenu("피드", "feed", "feed", List.of(
                                    makeSubMenu("피드", "feed", "/feed")
                            ));
                            break;
                        case "ROLE_NEWS" :
                            makeMainMenu("피드", "feed", "feed", List.of(
                                    makeSubMenu("뉴스", "news", "/news")
                            ));
                            break;
                    }
                });
    }

    /**
     * MyPageMenu
     * */
    private void initMyPageMenu(Collection<RoleDTO> roles) {
        makeDefaultMyPageMenu(roles);

        roles.stream()
                .forEach((role -> {
                    switch (role.getName()) {
                        case "ROLE_COMPANY_ADMIN":
                            makeMyPageMenu("플러그인", "plugin", "plugin", initPluginSubMenu(roles));
                            makeMyPageMenu("라이센스", "license", "license", initLicenseSubMenu(roles));
                            break;
                    }
                }));
    }
}
