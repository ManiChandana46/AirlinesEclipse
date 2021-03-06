package com.lti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello.api")
	public String sayHello(@RequestParam("name") String name) {
		return "Hello" + name + ". Welcome to Spring Boot";
	}

}
