package com.xyl.spring.practice.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyl.spring.practice.service.EmailService;

public class EventApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmailService emailService = (EmailService)context.getBean("emailService");
		
		String address = "known.hacker@example.org";
		String text = "foo";
		
		emailService.sendEmail(address, text);
		
	}
}
