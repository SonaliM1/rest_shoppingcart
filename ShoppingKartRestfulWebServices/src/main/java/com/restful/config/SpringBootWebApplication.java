package com.restful.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@SpringBootApplication
@ComponentScan("com.restful")
@EnableJpaRepositories("com.restful.dao")
@EntityScan("com.restful.model")
public class SpringBootWebApplication extends SpringBootServletInitializer {
     
	@Override 
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
		return applicationBuilder.sources(SpringBootWebApplication.class);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		SpringApplication.run(SpringBootWebApplication.class, args);
		
	}  

}
