package com.illunex.invest.companycomposite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.illunex.invest.companycomposite")
@EnableHystrix
@EnableDiscoveryClient
public class CompanyCompositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyCompositeApplication.class, args);
	}

}
