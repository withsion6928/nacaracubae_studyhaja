package com.nacaracubae.studyhaja;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableBatchProcessing
@EntityScan(basePackages = {"com.nacaracubae.studyhaja"})
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}, scanBasePackages = "com.nacaracubae.studyhaja")
@EnableJpaRepositories(basePackages = {"com.nacaracubae.studyhaja"})
public class NacaracubaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacaracubaeApplication.class, args);
	}

}
