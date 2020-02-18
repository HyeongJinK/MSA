package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.persistence.entity.CompanyEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT
        , properties = {"spring.datasource.url=jdbc:h2:mem:company"
        , "eureka.client.enabled=false"
        , "spring.cloud.config.enabled=false"})
public class CompanyRepositoryTest {
    @Autowired
    CompanyRepository repository;

    @Before
    public void setup() {
        CompanyEntity companyEntity = CompanyBuilder.getInstance()
                .userIdx(1l)
                .name("Test")
                .entityBuild();

        repository.save(companyEntity);
    }

    @Test
    public void findByUserIdx() {
        CompanyEntity companyEntity = repository.findByUserIdx(1l);

        Assert.assertEquals(companyEntity.getName(), "Test");
    }
}
