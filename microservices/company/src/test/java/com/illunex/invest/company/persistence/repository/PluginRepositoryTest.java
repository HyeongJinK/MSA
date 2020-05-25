package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.api.core.company.dto.enumable.PluginState;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Plugin;
import com.netflix.discovery.converters.Auto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT
        , properties = {"spring.datasource.url=jdbc:h2:mem:company"
        , "eureka.client.enabled=false"
        , "spring.cloud.config.enabled=false"})
public class PluginRepositoryTest {
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    PluginRepository pluginRepository;

    Company company;

    @Before
    public void setUp() {
        company = companyRepository.save(Company.builder()
                .name("test")
                .build());

        pluginRepository.save(Plugin.builder()
                .productId(1L)
                .state(PluginState.OPEN)
                .company(company)
                .build());
        pluginRepository.save(Plugin.builder()
                .productId(2L)
                .state(PluginState.CLOSE)
                .company(company)
                .build());
        pluginRepository.save(Plugin.builder()
                .productId(3L)
                .state(PluginState.OPEN)
                .company(company)
                .build());

    }

    @Test
    public void findByCompanyCompanyIdx() {
        List<Plugin> plugins = pluginRepository.findByCompanyCompanyIdxOrderByProductIdAsc(company.getCompanyIdx());

        Assert.assertEquals("갯수 체크", plugins.size(), 3);

        Assert.assertEquals(plugins.get(0).getProductId(), java.util.Optional.of(1L).get());
        Assert.assertEquals(plugins.get(0).getState(), PluginState.OPEN);
        Assert.assertEquals(plugins.get(1).getProductId(), java.util.Optional.of(2L).get());
        Assert.assertEquals(plugins.get(1).getState(), PluginState.CLOSE);
        Assert.assertEquals(plugins.get(2).getProductId(), java.util.Optional.of(3L).get());
        Assert.assertEquals(plugins.get(2).getState(), PluginState.OPEN);
    }
}