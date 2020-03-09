package com.illunex.invest.startup.controller.user;

import com.illunex.invest.startup.service.company.CompanyCompositeIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    CompanyCompositeIntegration companyCompositeIntegration;

    @GetMapping("/testUser")
    public void userTest() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null) {
            UserDetails userDetails = (UserDetails) principal;

            String username = userDetails.getUsername();
            String password = userDetails.getPassword();

            System.out.println(username);
            System.out.println(password);

            for (GrantedAuthority role : ((UserDetails) principal).getAuthorities()) {
                System.out.println(role.getAuthority());
            }
        }
    }

    @GetMapping("/testProduct")
    public void productTest() {
        companyCompositeIntegration.test();
    }
}
