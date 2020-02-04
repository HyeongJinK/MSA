package com.illunex.invest.company.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(basePackages = "com.illunex.invest.company")
@Import(FeignClientsConfiguration.class)
public class FeignClientsConfiguration {
}
