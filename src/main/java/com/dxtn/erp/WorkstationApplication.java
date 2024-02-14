package com.dxtn.erp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WorkstationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkstationApplication.class, args);
	}

}
