package com.example.circuitbreaker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.client.RestTemplate;

@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class CircuitBreakerMainApplication {

  @Autowired
  private CircuitBreakerService circuitBreakerService;

  @Bean
  public RestTemplate rest(RestTemplateBuilder builder) {
	  return builder.build();
  }

  @RequestMapping("/circuitBreaker")
  public String doCircuitBreaker() {
	  
	  System.out.println(">>> Main.doCircuitBreaker");
	  
	  return circuitBreakerService.getPrimary();
  }

  public static void main(String[] args) {
	  SpringApplication.run(CircuitBreakerMainApplication.class, args);
  }
}