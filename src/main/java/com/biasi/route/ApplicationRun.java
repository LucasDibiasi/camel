package com.biasi.route;
/**
 * @data 05/03/2018
 * @author lbiasi
 *
 */
import org.apache.camel.component.servlet.CamelHttpTransportServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AutoConfigurationPackage
public class ApplicationRun {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationRun.class, args);
	}
	
	@Bean		
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/rest/*");
		servlet.setName("CamelServlet");
		return servlet;
	}
}