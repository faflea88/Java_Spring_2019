package com.example.HelloWorld;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication
{

	@Value("${employee.name:Peter}")
	private String employeeName;

	public static void main(String[] args)
	{

		SpringApplication app = new SpringApplication(
				HelloWorldApplication.class);
		app.setDefaultProperties(
				Collections.singletonMap("server.port", "8083"));
		app.run(args);
	}

	@RequestMapping(value = "/")
	public String hello()
	{
		return "Hello World , " + employeeName;
	}

}
