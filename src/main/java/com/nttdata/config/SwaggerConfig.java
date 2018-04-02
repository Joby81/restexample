package com.nttdata.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private Environment enviornment;
	
	@Bean
	public Docket newsApi() {
		String microserviceName=enviornment.getProperty("spring.application.name", "Demo Rest Service");
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(microserviceName)
				.apiInfo(apiInfo(microserviceName))
				.select()
				// including only the controllers starting with e2g
		        .paths(regex("/api/user.*"))
				.build();
	}

	private ApiInfo apiInfo(String microserviceName) {
		return new ApiInfoBuilder()
				.title("Rest Example")
				.description("Simple Rest Implementation" + microserviceName + " )")
				.termsOfServiceUrl("http://www.nttdata.com")
				.contact("Abhai Jose")
				.license("NTT Data")
				.licenseUrl("http://www.nttdata.com")
				.version("0.0.1").build();
	}
}
