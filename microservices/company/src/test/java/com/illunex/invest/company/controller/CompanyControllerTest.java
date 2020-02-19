package com.illunex.invest.company.controller;

import com.illunex.invest.api.core.company.controller.CompanyController;
import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.company.builder.CompanyBuilder;
import com.illunex.invest.company.service.CompanyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:company"})
public class CompanyControllerTest {
    WebTestClient webTestClient;

    @MockBean
    CompanyService companyService;

    @Autowired CompanyController companyController;

    @Before
    public void setup() {
        when(companyService.getCompanyByUserIdx(1l))
                .thenReturn(CompanyBuilder.getInstance()
                        .companyIdx(1l)
                        .name("test")
                        .dtoBuild()
                );

        webTestClient = WebTestClient.bindToController(new CompanyControllerImpl(companyService))
                .configureClient()
                .baseUrl("")
                .build();
    }

    @Test
    public void getCompanyTest() {
        ResponseEntity<CompanyDTO> result = companyController.getCompany(1l);

        CompanyDTO company = result.getBody();

        Assert.assertEquals(company.getCompanyIdx().longValue(), 1l);
        Assert.assertEquals(company.getName(), "test");
    }

    @Test
    public void getCompanyHttpTest() {
        webTestClient.get()
                .uri("/company/user/1")
                .accept(APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectHeader().contentType(APPLICATION_JSON_UTF8)
                .expectBody()
                .jsonPath("companyIdx").isEqualTo("1")
                .jsonPath("name").isEqualTo("test");
    }
}
