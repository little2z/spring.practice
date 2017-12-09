package com.xyl.spring.practice.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

import com.xyl.spring.practice.event.BlackListEvent;

public class BlackListNotifier implements ApplicationListener<BlackListEvent> {
	
	private String notificationAddress;
	
	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}
	
	@Override
	public void onApplicationEvent(BlackListEvent event) {
		String result = String.format("receive blacklist event: %s ,notify %s", event, notificationAddress);
		System.out.println(result);
	}

}
