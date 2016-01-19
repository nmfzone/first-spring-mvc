package com.nmfzone.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nmfzone.app.config.App;

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "com.nmfzone.app")
public class Application
{

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
        // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// context.scan("com.nmfzone.app");
		// context.refresh();
    }

}
