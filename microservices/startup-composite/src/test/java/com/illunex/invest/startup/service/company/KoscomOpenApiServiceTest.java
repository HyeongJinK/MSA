package com.illunex.invest.startup.service.company;

import com.illunex.invest.api.composite.startup.company.model.NiceCompanyInfo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class KoscomOpenApiServiceTest {
    KoscomOpenApiService koscomOpenApiService = new KoscomOpenApiService();

    @Test
    public void companyInfo() {
        List<NiceCompanyInfo> niceCompanyInfos = koscomOpenApiService.companyOutlineIfo("4088118945");

        for (NiceCompanyInfo info : niceCompanyInfos) {
            System.out.println(info.toString());
        }
    }
}