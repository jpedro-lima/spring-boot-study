package com.studyspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {
	@Bean
	public OpenAPI CustOpenAPI() {
		return new OpenAPI()
		.info(new Info()
				.title("Study Spring Boot")
				.description("My First spring boot app")
				.version("v1.0")
				.termsOfService("http://swagger.io/terms/")
				.license(new License().name("Apache 2.0").url("http://springdoc.org"))
				.contact(null)
				);
	}
}
