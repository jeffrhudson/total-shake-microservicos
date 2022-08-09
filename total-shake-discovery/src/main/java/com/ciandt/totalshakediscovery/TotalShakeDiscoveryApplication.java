package com.ciandt.totalshakediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TotalShakeDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TotalShakeDiscoveryApplication.class, args);
	}

}
