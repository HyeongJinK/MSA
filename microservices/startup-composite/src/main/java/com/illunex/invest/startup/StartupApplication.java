package com.illunex.invest.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@EnableCaching
@SpringCloudApplication
public class StartupApplication {
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
		SpringApplication.run(StartupApplication.class, args);
	}
}
