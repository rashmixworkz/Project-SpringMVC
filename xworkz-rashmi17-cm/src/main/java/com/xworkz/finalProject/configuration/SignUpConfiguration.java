package com.xworkz.finalProject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan("com.xworkz.finalProject")
public class SignUpConfiguration {

	public SignUpConfiguration() {
		log.info("Running SignUpConfiguration in SignUpConfiguration class");
	}

	@Bean
	public ViewResolver resolver() {
		log.info("Running viewResolver");
		return new InternalResourceViewResolver("/", ".jsp");

	}

	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		log.info("localContainerEntityManagerFactoryBean registerd");
		LocalContainerEntityManagerFactoryBean container = new LocalContainerEntityManagerFactoryBean();
		return container;

	}
	@Bean
	public PasswordEncoder encoder() {
		log.info("Running PasswordEncoder");
		return new BCryptPasswordEncoder();
		
	}
	/*
	 * @Bean public MultipartResolver multipartResolver() {
	 * log.info("Running multipartResolver in configuration"); return new ;
	 * 
	 * }
	 */

}
