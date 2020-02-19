package com.illunex.invest.startup.controller;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.startup.service.CompanyServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    CompanyServiceProxy companyServiceProxy;


    @GetMapping(value = {"", "/"})
    public ModelAndView index(ModelAndView mv) {
        CompanyDTO data = companyServiceProxy.getCompanyByUserIdx(1l);

        mv.addObject("company", data);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = {"/test"})
    public ModelAndView test(ModelAndView mv) {
        CompanyDTO data = companyServiceProxy.getCompanyByUserIdx(1l);

        mv.addObject("company", data);
        mv.setViewName("test/test");
        return mv;
    }
}
