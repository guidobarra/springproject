package com.guba.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guba.spring.interfaces.Coach;

public class AnnotationsDemoAppTwo {

	public static void main(String[] args) {
		System.out.println("\nSTART create beans");
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("\nEND create beans");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
		
		
		// call a method on the bean
		System.out.println("\nthe method getDailyWorkout()");
		System.out.println(theCoach.getDailyWorkout());
		
		// close context
		context.close();
	}

}
