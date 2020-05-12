package com.illunex.invest.startup.service.menu;

import com.illunex.invest.api.composite.startup.menu.dto.MenuDto;
import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.startup.service.DefaultIntegrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Service
public class MenuServiceImpl extends DefaultIntegrationService {
    public MenuServiceImpl(RestTemplate restTemplate, WebClient.Builder loadBalanceWebClientBuilder) {
        super(restTemplate, loadBalanceWebClientBuilder);
    }

    public MenuDto getMenus() {
        UserDTO userDTO = getUser();
        //ResponseEntity<ListDTO> irList = restTemplate.getForEntity(irUrl + "/ir/list?companyIdx={companyIdx}", ListDTO.class, userDTO.getCompanyIdx());
        return new MenuDto(userDTO.getAuthorities(), new ArrayList<>()/*irList.getBody().getIrList()*/);
    }
}
