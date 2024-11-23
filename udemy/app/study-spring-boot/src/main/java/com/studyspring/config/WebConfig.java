
package com.studyspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	// Query parameter
	// @Override
	// public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	// 	configurer.favorParameter(true);
	// 	configurer.parameterName("mediaType");
	// 	configurer.ignoreAcceptHeader(true);
	// 	configurer.useRegisteredExtensionsOnly(false);
	// 	configurer.defaultContentType(MediaType.APPLICATION_JSON);
	// 	configurer.mediaType("xml", MediaType.APPLICATION_XML);
	// 	configurer.mediaType("json", MediaType.APPLICATION_JSON);
	// }

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false);
		configurer.ignoreAcceptHeader(false);
		configurer.useRegisteredExtensionsOnly(false);
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
		configurer.mediaType("xml", MediaType.APPLICATION_XML);
		configurer.mediaType("json", MediaType.APPLICATION_JSON);
	}

}