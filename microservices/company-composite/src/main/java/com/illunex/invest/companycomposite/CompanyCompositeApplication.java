package com.illunex.invest.companycomposite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.illunex.invest.companycomposite")
@EnableDiscoveryClient
@SpringBootApplication
//@EnableSwagger2
public class CompanyCompositeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyCompositeApplication.class, args);
	}

//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any())
//				.build();
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfo("Service Name", "API Description", "API", "Terms of service",
//				new Contact("name", "webaddress", "email"), "License of API", "API license URL",
//				Collections.emptyList());
//	}
}
