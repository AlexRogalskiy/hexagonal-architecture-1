package com.baeldung.springboot.application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author Neeraj Sidhaye
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.baeldung.springboot.*")
@EnableJpaRepositories("com.baeldung.springboot.*")
@EntityScan("com.baeldung.springboot.*")
public class SpringBootMainApplication {
	
	public static void main(String[] args) {
		
		SpringApplication application=new SpringApplication(SpringBootMainApplication.class);
		application.addListeners(new ApplicationPidFileWriter());
		SpringApplication.run(SpringBootMainApplication.class, args);
	}
	

    public static void start()  {
    	 SpringApplication.run(SpringBootMainApplication.class);
    }
    
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
}
