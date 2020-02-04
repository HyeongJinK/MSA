package com.illunex.invest.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.illunex.invest.company"
				, "com.illunex.invest.common"},
		excludeFilters = {@ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {TypeExcludeFilter.class}
		), @ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {AutoConfigurationExcludeFilter.class}
		)}
)
@EnableDiscoveryClient
public class CompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApplication.class, args);
	}

}
