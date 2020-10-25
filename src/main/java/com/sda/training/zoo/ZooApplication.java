package com.sda.training.zoo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(ZooConfiguration.class)
public class ZooApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(ZooApplication.class, args);
//		Arrays.stream(run.getBeanDefinitionNames())
//			.forEach(System.out::println);
	}

}
