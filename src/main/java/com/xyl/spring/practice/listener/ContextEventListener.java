package com.xyl.spring.practice.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;

import com.xyl.spring.practice.event.BlackListEvent;

public class ContextEventListener {
	
	
	@EventListener
	public void onContextRefreshed(ContextRefreshedEvent event){
		doEvent(event);
	}
	
	@EventListener
	public void onContextStarted(ContextStartedEvent event){
		doEvent(event);
	}
	
	@EventListener
	public void onContextStopped(ContextStoppedEvent event){
		doEvent(event);
	}
	
	@EventListener
	public void onContextClosed(ContextClosedEvent event){
		doEvent(event);
	}
	
	private void doEvent(ApplicationEvent event){
		System.out.println("event:"+event);
	}
	
	@Order(2)
	@Async
	@EventListener(condition = "#a0.test == 'foo' ")
	public void onBlackListEvent(BlackListEvent blackListEvent){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("the blackListEvent test attr is foo");
	}
	
}
