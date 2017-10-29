package com.xyl.spring.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.xyl.spring.practice.entity.Student;

@PropertySource("classpath:log4j.properties")
@Service
public class NetworkService {
	
	@Autowired
	private Student student;
	
	private Long time;
	
	@Autowired
	private Environment env;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "NetworkService [student=" + student + ", time=" + time + "]"+env.getProperty("log4j.rootLogger");
	}
	
	
}
