package com.scrapeWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan; 

@SpringBootApplication
//@ComponentScan(value = "com.service" useDefaultFilters = false)
@ComponentScan({"com.service","com.controller","com.repository"})
@EntityScan(basePackages = "com.spring.bean")
//@ImportResource({"classpath*:applicationContext.xml"})
public class SbScraperAppApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SbScraperAppApplication.class, args);
	}

}
