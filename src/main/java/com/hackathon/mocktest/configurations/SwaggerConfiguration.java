package com.hackathon.mocktest.configurations;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

	@Value("${swagger.api-info.title}")
	private String title;
	@Value("${swagger.api-info.description}")
	private String description;
	@Value("${swagger.api-info.version}")
	private String version;
	@Value("${swagger.api-info.termsOfServiceUrl}")
	private String tos;
	@Value("${swagger.api-info.contact.name}")
	private String contactName;
	@Value("${swagger.api-info.contact.email}")
	private String contactEmail;
	@Value("${swagger.api-info.license}")
	private String license;
	@Value("${swagger.api-info.licenseUrl}")
	private String licenseUrl;

	@Bean
	public Docket getDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/api/**")).apis(RequestHandlerSelectors.basePackage("com.hackathon.mocktest")).build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(title, description, version, tos, new Contact(contactName, "", contactEmail), license, licenseUrl, Collections.EMPTY_LIST);
	}
}
