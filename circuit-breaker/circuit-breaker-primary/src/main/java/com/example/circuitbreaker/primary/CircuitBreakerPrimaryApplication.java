package com.example.circuitbreaker.primary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CircuitBreakerPrimaryApplication {

  @RequestMapping(value = "/primary")
  public String getPrimary(){
	  
	  System.out.println("==> Primary.getPrimary /primary (8094)");
	  
	  return "We hit the primary REST service instance listening on port 8094";
  }

  public static void main(String[] args) {
	  SpringApplication.run(CircuitBreakerPrimaryApplication.class, args);
  }

}
