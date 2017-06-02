package com.xiaohoo.api.common.util;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Kavin on 2017/5/1.
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig  extends WebMvcConfigurerAdapter {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
						.basePackage("com.xiaohoo.api.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.globalResponseMessage(
						RequestMethod.GET,
						newArrayList(
								new ResponseMessageBuilder().code(500)
										.message("500 message")
										.responseModel(new ModelRef("Error"))
										.build(), new ResponseMessageBuilder()
										.code(403).message("Forbidden!!!!!")
										.build())).pathMapping("/");
	}

	private ApiInfo apiInfo() {
		
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("My Apps API Title",
				"My Apps API Description", "API TOS",
				"My Apps API terms of service", "My Apps API Contact Email", "License of API",
				"API license URL");
		return apiInfo;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations(
				"classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations(
				"classpath:/META-INF/resources/webjars/");
	}
}