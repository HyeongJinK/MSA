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

    private Menu makeSubMenu(String title, String id, String to, List<Menu> subMenus) {
        return Menu.builder()
                .title(title)
                .id(id)
                .to(to)
                .subMenu(subMenus)
                .build();
    }

    private List<Menu> initDashBoardSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("대시보드", "main", "/dashboard/main"));
    }

    private List<Menu> makeInvestSubMenu(RoleDTO role) {
        return List.of(makeSubMenu("심사", "evaluate", "/invest/evaluate"),
                makeSubMenu("라운드공지", "round", "/invest/round/list"
                        , List.of(makeSubMenu("전체", "list", "/invest/round/list"),
                                makeSubMenu("진행중", "proceeding", "/invest/round/proceeding"),
                                makeSubMenu("마감", "end", "/invest/round/end"))
                ),
                makeSubMenu("설정", "setting", "/invest/setting"));
    }

    private List<Menu> initAlarmSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("전체알람", "alarm", "/myPage/alarm/list"),
                makeSubMenu("온라인심사", "evaluate", "/myPage/alarm/evaluate"),
                makeSubMenu("포트폴리오 연결", "portfolio", "/myPage/alarm/portfolio"));
    }

    private List<Menu> initAccountSubMenu(Collection<RoleDTO> roles) {
        List<Menu> accountSubMenu = new ArrayList<>();
        accountSubMenu.add(makeSubMenu("프로필 수정", "myPage", "/myPage/account/profile"));
        accountSubMenu.add(makeSubMenu("비밀번호 변경", "password", "/myPage/account/password"));
        accountSubMenu.add(makeSubMenu("서명관리", "signature", "/myPage/account/signature"));

        roles.stream()
                .filter(role -> role.getName().equals("ROLE_COMPANY_ADMIN"))
                .forEach(role -> {
                    accountSubMenu.add(makeSubMenu("권한설정", "permission", "/myPage/account/permission/list"));
                    accountSubMenu.add(makeSubMenu("사업자등록 인증", "business", "/myPage/account/business"));
                });

        return accountSubMenu;
    }

    private List<Menu> initPluginSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("전체 플러그인", "plugin", "/myPage/plugin/list"));
    }

    private List<Menu> initLicenseSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("요금안내", "license", "/myPage/license/payment"),
                makeSubMenu("고객센터", "support", "/myPage/license/support"));
    }

    private List<Menu> initConnectSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("투자사연결", "connect", "/myPage/connect/vc"),
                makeSubMenu("팀원연결", "member", "/myPage/connect/member"));
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

    private void initMainMenu(Collection<RoleDTO> roles, List<IRDTO> irList) {
        boolean companyMenu = true;
        makeDefaultMainMenu(roles);

        roles.stream()
                .forEach(role -> {
                    switch (role.getName()) {
                        case "ROLE_COMPANY":
                            makeMainMenu("기업", "company", "company", makeCompanySubMenu(roles));
                            break;
                        case "ROLE_IR":
                            makeMainMenu("IR 작성", "ir", "ir", makeIrSubMenu(role, irList));
                            break;
                        case "ROLE_INVEST":
                            makeMainMenu("심사", "invest", "invest", makeInvestSubMenu(role));
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
        makeMyPageMenu("계정설정", "myPage", "myPage", initAccountSubMenu(roles));
        makeMyPageMenu("알람", "alarm", "alarm", initAlarmSubMenu(roles));

        roles.stream()
                .forEach((role -> {
                    switch (role.getName()) {
                        case "ROLE_COMPANY_ADMIN":
                            makeMyPageMenu("플러그인", "plugin", "plugin", initPluginSubMenu(roles));
                            makeMyPageMenu("연결관리", "connect", "connect", initConnectSubMenu(roles));
                            makeMyPageMenu("라이센스", "license", "license", initLicenseSubMenu(roles));
                            break;
                    }
                }));
    }


}
