package com.xyl.spring.practice;

import org.junit.Test;

import com.xyl.spring.practice.entity.Animal;
import com.xyl.spring.practice.entity.Cat;

public class ClassTest {
	
	@Test
	public void testClassAssign(){
		
		System.out.println(Animal.class.isAssignableFrom(Cat.class));
		System.out.println(Cat.class.isAssignableFrom(Animal.class));
		
		Animal cat1 = new Cat("cat");
		Cat cat2 = new Cat("cat");
		
		System.out.println(Cat.class.isAssignableFrom(cat1.getClass()));
		System.out.println(Cat.class.isAssignableFrom(cat2.getClass()));
	}
	
}
