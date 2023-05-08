package com.madbarsoft.simplewebapp.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String index() {
		LOGGER.info("Welcome to SimpleWebApp !");
		return "Welcome to SimpleWebApp!";
	}

	@GetMapping("/home")
	public String helloFromHome() {
		LOGGER.info("Hello from SimpleWebApp Home !");
		return "Hello from SimpleWebApp Home !";
	}
	
	@GetMapping("/restcall")
	public String restCall() {
		String reqUrl = "https://reqres.in/api/users?page=2";
		String resObj = this.restTemplate.getForObject(reqUrl, String.class);

		LOGGER.info("restCall:" + resObj);

		return resObj;
	}
	
	
	
	

}