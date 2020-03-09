package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.persistence.repository.CompanyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false"
        , "spring.cloud.config.enabled=false"
        , "spring.datasource.url=jdbc:h2:mem:company"})
public class CompanyServiceTest {
    @MockBean
    CompanyRepository companyRepository;
    @Autowired CompanyService companyService;

    @Before
    public void setup() {
        when(companyRepository.findById(1l))
                .thenReturn(Optional.of(CompanyBuilder.getInstance()
                        .companyIdx(1l)
                        .name("test")
                        .entityBuild()));
        when(companyRepository.findById(2l))
                .thenReturn(Optional.empty());
    }

    @Test
    public void findByUserIdxTest() {
        CompanyDTO company = companyService.getCompanyById(1l);

        Assert.assertEquals(company.getName(), "test");
    }

    @Test(expected = NoneCompanyException.class)
    public void findByUserIdxNullTest() throws NoneCompanyException {
        CompanyDTO company = companyService.getCompanyById(2l);
    }
}
