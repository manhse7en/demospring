package com.ccs1hnue.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry)
	{
		registry.addMapping("/redis")
				.allowedOrigins("http://localhost:8181", "http://localhost:8282")
				.allowedMethods("POST", "GET", "PUT", "DELETE")
				.allowedHeaders("Content-Type")
				.exposedHeaders("header-1", "header-2")
				.allowCredentials(false)
				.maxAge(6000);
	}
}
