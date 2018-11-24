package com.barath.app;

import java.net.InetAddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}
	
	
	@GetMapping(value="/")
	public String ip() throws Throwable {
		return "HOST:"+InetAddress.getLocalHost().getHostName()+", IP: "+InetAddress.getLocalHost().getHostAddress();
	}
}
