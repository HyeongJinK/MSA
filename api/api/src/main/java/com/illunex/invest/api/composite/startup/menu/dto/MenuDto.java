package com.illunex.invest.api.composite.startup.menu.dto;

import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.user.dto.RoleDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private List<Menu> main = new ArrayList<>();
    private List<Menu> myPage = new ArrayList<>();

    public List<Menu> getMain() {
        return main.stream()
                .sorted(Comparator.comparingInt(Menu::getOrder))
                .collect(Collectors.toList());
    }

    public List<Menu> getMyPage() {
        return myPage.stream()
                .sorted(Comparator.comparingInt(Menu::getOrder))
                .collect(Collectors.toList());
    }

    public MenuDto(Collection<RoleDTO> roles, List<IRDTO> irList) {
        initMainMenu(roles, irList);
        initMyPageMenu(roles);
    }

    private void makeMainMenu(String title, String id, String icon, List<Menu> subMenus, int order) {
        main.add(Menu.builder()
                .title(title)
                .id(id)
                .icon(icon)
                .subMenu(subMenus)
                .order(order)
                .build());
    }

    private void makeMyPageMenu(String title, String id, String icon, List<Menu> subMenus, int order) {
        myPage.add(Menu.builder()
                .title(title)
                .id(id)
                .icon(icon)
                .subMenu(subMenus)
                .order(order)
                .build());
    }

    private Menu makeSubMenu(String title, String id, String to, int order) {
        return makeSubMenu(title, id, to, null, order, true);
    }

    private Menu makeSubMenu(String title, String id, String to, int order, boolean disable) {
        return makeSubMenu(title, id, to, null, order, disable);
    }

    private Menu makeSubMenu(String title, String id, String to, List<Menu> subMenus, int order) {
        return makeSubMenu(title, id, to, subMenus, order, true);
    }

    private Menu makeSubMenu(String title, String id, String to, List<Menu> subMenus, int order, boolean disable) {
        return Menu.builder()
                .title(title)
                .id(id)
                .to(to)
                .subMenu(subMenus)
                .order(order)
                .disable(disable)
                .build();
    }

    private List<Menu> initDashBoardSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("대시보드", "main", "/dashboard/main", 1));
    }

    private List<Menu> makeInvestSubMenu(RoleDTO role) {
        return List.of(makeSubMenu("심사", "evaluate", "/invest/evaluate", 1),
                makeSubMenu("라운드공지", "round", "/invest/round/list"
                        , List.of(makeSubMenu("전체", "list", "/invest/round/list", 1),
                                makeSubMenu("진행중", "proceeding", "/invest/round/proceeding", 2),
                                makeSubMenu("마감", "end", "/invest/round/end",3 ))
                        .stream().sorted(Comparator.comparingInt(Menu::getOrder)).collect(Collectors.toList())
                        , 2
                ),
                makeSubMenu("설정", "setting", "/invest/setting", 3))
                .stream().sorted(Comparator.comparingInt(Menu::getOrder)).collect(Collectors.toList());
    }

    private List<Menu> initAlarmSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("전체알람", "alarm", "/myPage/alarm/list", 1),
                makeSubMenu("온라인심사", "evaluate", "/myPage/alarm/evaluate", 2),
                makeSubMenu("포트폴리오 연결", "portfolio", "/myPage/alarm/portfolio", 3))
                .stream().sorted(Comparator.comparingInt(Menu::getOrder)).collect(Collectors.toList());
    }

    private List<Menu> initAccountSubMenu(Collection<RoleDTO> roles) {
        List<Menu> accountSubMenu = new ArrayList<>();
        accountSubMenu.add(makeSubMenu("프로필 수정", "myPage", "/myPage/account/profile", 1));
        accountSubMenu.add(makeSubMenu("비밀번호 변경", "password", "/myPage/account/password", 2));
        accountSubMenu.add(makeSubMenu("서명관리", "signature", "/myPage/account/signature", 3));

        roles.stream()
                .filter(role -> role.getName().equals("ROLE_COMPANY_ADMIN"))
                .forEach(role -> {
                    accountSubMenu.add(makeSubMenu("권한설정", "permission", "/myPage/account/permission/list", 4));
                    accountSubMenu.add(makeSubMenu("사업자등록 인증", "business", "/myPage/account/business", 5));
                });

        return accountSubMenu.stream().sorted(Comparator.comparingInt(Menu::getOrder)).collect(Collectors.toList());
    }

    private List<Menu> initPluginSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("전체 플러그인", "plugin", "/myPage/plugin/list", 1));
    }

    private List<Menu> initLicenseSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("요금안내", "license", "/myPage/license/payment", 1),
                makeSubMenu("고객센터", "support", "/myPage/license/support", 2))
                .stream()
                .sorted(Comparator.comparingInt(Menu::getOrder))
                .collect(Collectors.toList());
    }

    private List<Menu> initConnectSubMenu(Collection<RoleDTO> roles) {
        return List.of(makeSubMenu("투자사연결", "connect", "/myPage/connect/vc", 1),
                makeSubMenu("팀원연결", "member", "/myPage/connect/member", 2))
                .stream()
                .sorted(Comparator.comparingInt(Menu::getOrder))
                .collect(Collectors.toList());
    }

    @NotNull
    private List<Menu> makeCompanySubMenu(RoleDTO role) {
        return List.of(makeSubMenu("기업정보", "info", "/company/info", 1),
                makeSubMenu("제품정보", "product", "/company/product", 2),
                makeSubMenu("팀정보", "member", "/company/member",3))
                .stream()
                .sorted(Comparator.comparingInt(Menu::getOrder))
                .collect(Collectors.toList());
//        makeSubMenu("주주정보", "shareholder", "/company/shareholder", 4);
    }

    private List<Menu> makeIrSubMenu(RoleDTO role, List<IRDTO> irList) {
        List<Menu> subMenu = new ArrayList<>();
        subMenu.add(makeSubMenu("All", "list", "/ir/list", 0));
        subMenu.addAll(irList.stream()
                .map(ir -> makeSubMenu(ir.getYear(),ir.getYear(), "/ir/"+ir.getYear(), Integer.parseInt(String.valueOf(ir.getIdx()))))
                .collect(Collectors.toList()));
        return subMenu.stream().sorted(Comparator.comparingInt(Menu::getOrder)).collect(Collectors.toList());
    }

    @NotNull
    private void makeDefaultMainMenu(Collection<RoleDTO> roles) {
        main.add(Menu.builder()
                .title("대시보드")
                .id("dashboard")
                .icon("dashboard")
                .subMenu(initDashBoardSubMenu(roles))
                .order(1)
                .build());
    }

    private void initMainMenu(Collection<RoleDTO> roles, List<IRDTO> irList) {
        makeDefaultMainMenu(roles);
        //TODO 주주, 문서
        roles.stream()
                .forEach(role -> {
                    switch (role.getName()) {
                        case "ROLE_COMPANY":
                            makeMainMenu("기업", "company", "company", makeCompanySubMenu(role), 2);
                            break;
                        case "ROLE_IR":
                            makeMainMenu("IR 작성", "ir", "ir", makeIrSubMenu(role, irList), 3);
                            break;
                        case "ROLE_INVEST":
                            makeMainMenu("심사", "invest", "invest", makeInvestSubMenu(role), 4);
                            break;
                        case "ROLE_FEED":
                            makeMainMenu("피드", "feed", "feed", List.of(
                                    makeSubMenu("피드", "feed", "/feed", 1)
                            ), 5);
                            break;
                        case "ROLE_SHAREHOLDER" : makeMainMenu("주주", "feed", "feed", List.of(
                                makeSubMenu("주주명부", "feed", "/feed", 1)
                        ), 6);
                        case "ROLE_DOC" : makeMainMenu("문서", "feed", "feed", List.of(
                                makeSubMenu("All", "feed", "/feed", 1)
                        ), 7);
                            break;
                        case "ROLE_NEWS" :
                            makeMainMenu("뉴스", "news", "news", List.of(
                                    makeSubMenu("뉴스", "news", "/news", 1)
                            ), 10);
                            break;
                    }
                });
    }

    /**
     * MyPageMenu
     * */
    private void initMyPageMenu(Collection<RoleDTO> roles) {
        makeMyPageMenu("계정설정", "myPage", "myPage", initAccountSubMenu(roles), 1);
        makeMyPageMenu("알람", "alarm", "alarm", initAlarmSubMenu(roles), 2);

        roles.stream()
                .forEach((role -> {
                    switch (role.getName()) {
                        case "ROLE_COMPANY_ADMIN":
                            makeMyPageMenu("플러그인", "plugin", "plugin", initPluginSubMenu(roles), 3);
                            makeMyPageMenu("연결관리", "connect", "connect", initConnectSubMenu(roles), 4);
                            makeMyPageMenu("라이센스", "license", "license", initLicenseSubMenu(roles), 5);
                            break;
                    }
                }));
    }
}
