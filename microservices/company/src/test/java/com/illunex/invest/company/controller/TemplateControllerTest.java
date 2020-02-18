package com.illunex.invest.company.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=RANDOM_PORT, properties = {
        "eureka.client.enabled=false",
        "spring.cloud.config.enabled=false",
        "spring.datasource.url=jdbc:h2:mem:company"})
public class TemplateControllerTest {
    WebTestClient webTestClient;

    @Before
    public void before() {
        webTestClient = WebTestClient.bindToController(new TemplateController())
                .configureClient()
                .baseUrl("")
                .build();
    }
    @Test
    public void testCall() throws Exception {
        webTestClient.get()
                .uri("/test")
                .accept(APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectHeader().contentType(APPLICATION_JSON_UTF8)
                .expectBody(String.class);
    }

    @Test
    public void errorTemplateCall() {
        webTestClient.get()
                .uri("/errorTemplate")
                .accept(APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectHeader().contentType(APPLICATION_JSON_UTF8)
                .expectBody(String.class);
    }
}
