package com.app.springbootrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing
@SpringBootApplication
public class SpringBootApplications extends SpringBootServletInitializer{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SpringApplication.run(SpringBootApplications.class, args);
	      SpringApplication.run(SpringBootApplications.class, args);

	}
	
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
//		return springApplicationBuilder.sources(SpringBootApplications.class);
//		
//	}

}
