package com.easyfly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {
    org.springframework.boot.actuate.autoconfigure.metrics.SystemMetricsAutoConfiguration.class
})

public class EasyflyApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyflyApplication.class, args);
	}

}
