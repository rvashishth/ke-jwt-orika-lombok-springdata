package com.us.app.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rvashishth
 *
 */
@Profile(value = {"dev","test"})
@Configuration
@EnableSwagger2
public class SwaggerUIConfig {

	@Bean
	public Docket api() {
		
		 ParameterBuilder aParameterBuilder = new ParameterBuilder();
	     aParameterBuilder.name("Authorization").modelRef(new ModelRef("string")).parameterType("header").required(true).build();
	     List<Parameter> operationParameters = new ArrayList<>();
	     operationParameters.add(aParameterBuilder.build());
	        
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(ApiInfo.DEFAULT).enable(true)
				.globalOperationParameters(operationParameters)
				.select().apis(RequestHandlerSelectors.basePackage("com.airtel.kyc.kenya.controller"))
				.build();
	}
}
