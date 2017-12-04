package com.xyl.spring.practice.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xyl.spring.practice.service.impl.UserService;

public class SpringJdbc {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = context.getBean(UserService.class);
//		userService.createTable();
		
		//获取所有用户
		int allUser = userService.getUserCount();
		System.out.println("所有用户："+ allUser);
		
//		String user1 = "赵六";
//		long userId = userService.insertUser(user1);
//		System.out.println(String.format("增加用户 %s 成功，id 为 %d", user1, userId));
		
		try {
			userService.updateUserName(4L, "newName6");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("所有用户："+ userService.getAllUser());
	}
}
