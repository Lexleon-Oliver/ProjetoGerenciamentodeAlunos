package com.development.studentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

@SpringBootApplication(exclude = {})
public class StudentapiApplication{

	public static void main(String[] args) {
		SpringApplication.run(StudentapiApplication.class, args);
	}

}
