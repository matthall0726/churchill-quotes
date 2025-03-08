package com.discordapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages =  {"com.discordapi.Controller"})
public class SpringRunner {


	public static void main(String[] args) {
		SpringApplication.run(SpringRunner.class, args);
		System.out.println("App is running!");
	}


}
