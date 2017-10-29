package com.xyl.spring.practice.app;

import java.util.Map;
import java.util.Properties;

public class SystemProperty {
	
	public static void main(String[] args) {
		Properties props = System.getProperties();
		System.out.println("-----System Property-------");
		props.forEach((key,value) -> System.out.println(key+"->"+value));
		System.out.println("-----System Property-------");
		
		Map<String, String> maps = System.getenv();
		System.out.println("-----System Env-------");
		maps.forEach((key,value) -> System.out.println(key+"->"+value));
		System.out.println("-----System Env-------");
	}
}
