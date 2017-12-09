package com.xyl.spring.practice.service;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

import com.xyl.spring.practice.event.BlackListEvent;

public class EmailService implements ApplicationEventPublisherAware{
	
	private List<String> blackList;
	
	private ApplicationEventPublisher applicationEventPublisher;
	
	@Override
	public void setApplicationEventPublisher(
			ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}
	
	public void setBlackList(List<String> blackList){
		this.blackList = blackList;
	}
	
	public void sendEmail(String address, String text){
		if(this.blackList.contains(address)){
			//存在黑名单内
			BlackListEvent blackListEvent = new BlackListEvent(this,address, text);
			this.applicationEventPublisher.publishEvent(blackListEvent);
			System.out.println("finished publish blackList event");
			return;
		}
		//send Email
		System.out.println(String.format("sendEmail address:%s ,content:%s", address, text));
	}
}
