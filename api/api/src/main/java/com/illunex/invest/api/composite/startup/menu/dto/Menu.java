package com.illunex.invest.api.composite.startup.menu.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
class Menu {
    private String title;
    private String id;
    private String icon;
    private String to;
    private List<Menu> subMenu = new ArrayList<>();
    private int order;
    private boolean disable = true;
}
