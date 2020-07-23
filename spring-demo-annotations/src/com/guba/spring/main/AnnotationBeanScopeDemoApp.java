package com.guba.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guba.spring.interfaces.Coach;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		System.out.println("\nSTART create beans");
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("\nEND create beans");
		
		// get the bean from spring container, default bean id is the name class impl
		Coach theCoach = context.getBean("pingPongCoach", Coach.class);
		Coach alphaCoach = context.getBean("pingPongCoach", Coach.class);
		
		// check if they are the some, pordefect is singleton scope
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("Pointing to the some Object: " + result);
		System.out.println("Memory location for theCoach: " + theCoach);
		System.out.println("Memory location for alphaCoach: " + alphaCoach);
		
		// clsoe the context
		context.close();
	}

}
