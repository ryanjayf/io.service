package io.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ServiceApplication {

	@Autowired
	private ServiceConfiguration properties;
	
	@Value("${some.other.property}")
	private String someOtherProperty;
	
//	@Value("${service.instance.name}")
//	private String instance;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	
//	@RequestMapping("/")
//	public String message() {
//		return "Hello from " + instance;
//	}
	
	@RequestMapping
	public String printConfig() {
		StringBuilder sb = new StringBuilder();
		sb.append(properties.getProperty());
		sb.append(" || ");
		sb.append(someOtherProperty);
		
		return sb.toString();
	}

}
