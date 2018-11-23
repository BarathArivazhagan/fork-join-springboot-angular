package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BankServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankServiceApplication.class, args);
	}
	
	
	@GetMapping
	public String ip() throws Throwable {
		return "HOST:"+InetAddress.getLocalHost().getHostName()+", IP: "+InetAddress.getLocalHost().getHostAddress();
	}
}
