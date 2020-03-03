package com.illunex.invest.startup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients("com.illunex.invest.startup")
//@EnableHystrix
@EnableDiscoveryClient
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
