package br.com.vuttr.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
	return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("br.com.vuttr"))
			.paths(regex("/tools.*"))
			.build().
			apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder()
		.title("Spring Boot REST API")
		.description("\"REST API para registro de API's muito úteis no dia a dia\"")
		.version("1.0.0")
		.license("Apache License Version 1.0")
		.licenseUrl("https://www.apache.org/licenses/LICENSE-1.0\"")
		.contact(" Osmar Araujo, contato: araujooa@gmail.com ")
		.build();
	}
	
}


