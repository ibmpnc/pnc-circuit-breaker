package com.example.circuitbreaker.secondary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CircuitBreakerSecondaryApplication {

  @RequestMapping(value = "/secondary")
  public String getSecondary(){
	  
	  System.out.println("==> Primary.getSecondary /secondary (8096)");
	  
	  return "We hit the secondary REST service instance listening on port 8096";
  }

  public static void main(String[] args) {
	  SpringApplication.run(CircuitBreakerSecondaryApplication.class, args);
  }

}
