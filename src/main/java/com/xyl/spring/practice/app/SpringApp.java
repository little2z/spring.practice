package com.xyl.spring.practice.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyl.spring.practice.entity.Student;
import com.xyl.spring.practice.service.NetworkService;

public class SpringApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = context.getBean("student",Student.class);
		System.out.println(student);
		
		NetworkService networkService = context.getBean(NetworkService.class);
		System.out.println(networkService);
	}
}	
