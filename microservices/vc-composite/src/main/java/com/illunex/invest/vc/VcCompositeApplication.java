package com.illunex.invest.vc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableCaching
@SpringBootApplication
public class VcCompositeApplication {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {return new RestTemplate();}

	@Bean
	@LoadBalanced
	public WebClient.Builder loadBalanceWebClientBuilder() {
		final WebClient.Builder builder = WebClient.builder();
		return builder;
	}

	public static void main(String[] args) {
		SpringApplication.run(VcCompositeApplication.class, args);
	}
}
