package com.illunex.invest.startup.controller.user;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.user.controller.MenuCompositeController;
import com.illunex.invest.startup.service.menu.MenuServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MenuCompositeControllerImpl implements MenuCompositeController {
    private final MenuServiceImpl menuService;

    @Override
    public ResponseEntity<ResponseData> getMenu() {
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .message("success")
                .data(menuService.getMenus())
                .build());
    }
}
