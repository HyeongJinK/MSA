package com.illunex.invest.startup.service.user;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway")
@RibbonClient(name = "company")
public interface Test2Service {
    @GetMapping("/company/company/user/1")
    ResponseEntity<CompanyDTO> getCompanyByUserIdx();
}
