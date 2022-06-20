package com.rubix.example.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);
		
		StudentService service = context.getBean(StudentService.class);
		service.displayEntites();
		service.modifyEntities();
		//System.out.println("Hello Students");
	}

}
