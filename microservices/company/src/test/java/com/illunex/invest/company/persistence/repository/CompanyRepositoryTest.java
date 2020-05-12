package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.MainProduct;
import com.illunex.invest.company.persistence.entity.MainProductLine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT
        , properties = {"spring.datasource.url=jdbc:h2:mem:company"
        , "eureka.client.enabled=false"
        , "spring.cloud.config.enabled=false"})
@Transactional
public class CompanyRepositoryTest {
    @Autowired
    CompanyRepository repository;
    Company company;
    @Before
    public void setup() {
        List<MainProductLine> mainProductLines = new ArrayList<>();
        mainProductLines.add(new MainProductLine("SI"));
        mainProductLines.add(new MainProductLine("보안"));
        MainProduct mainProduct = MainProduct.builder().mainProductLines(mainProductLines).build();
        company = repository.save(Company.builder()
                .name("Test")
                .mainProduct(mainProduct)
                .build());
    }

    @Test
    public void findByUserIdx() {
        Company result = repository.findById(company.getCompanyIdx()).get();
        Assert.assertEquals(result.getName(), "Test");
    }
}
