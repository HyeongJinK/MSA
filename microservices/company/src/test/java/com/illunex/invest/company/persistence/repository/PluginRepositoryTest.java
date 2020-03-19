package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Company;
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
public class PluginRepositoryTest {
    @Autowired
    PluginRepository pluginRepository;

    @Before
    public void setUp() {
        Company.builder()
                .build();
    }

    @Test
    public void findByCompanyCompanyIdx() {

    }
}