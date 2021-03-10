package com.example.circuitbreaker.main;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class CircuitBreakerService {

  private final RestTemplate restTemplate;

  public CircuitBreakerService(RestTemplate rest) {
	  this.restTemplate = rest;
  }

  @HystrixCommand(fallbackMethod = "secondary")
  public String getPrimary() {
	  
	  System.out.println(">>>>>> Main.Service.getPrimary");
	  
	  URI uri = URI.create("http://localhost:8094/primary");

	  return this.restTemplate.getForObject(uri, String.class);
  }

  public String secondary() {

	  System.out.println(">>>>>> Main.Service.secondary");
	  
	  try {
		
		  URI uri = URI.create("http://localhost:8096/secondary");

		  return this.restTemplate.getForObject(uri, String.class);
		  
	} catch (RestClientException rce) {
		//rce.printStackTrace();
		
		System.out.println(">>>>>> Main.Service.secondary RestClientException :" + rce.getMessage());
		
		return "Secondary REST service instance FAILED but main is still responding on port 8092";
	}
  }

}