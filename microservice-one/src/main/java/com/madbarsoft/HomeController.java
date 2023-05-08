package com.madbarsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/")
	public String index() {
		LOGGER.info("Welcome to MicroserviceOne !");
		return "Welcome to MicroserviceOne!";
	}

	@GetMapping("/home")
	public String helloFromHome() {
		LOGGER.info("Hello from MicroserviceOne Home !");
		return "Hello from MicroserviceOne Home !";
	}

}