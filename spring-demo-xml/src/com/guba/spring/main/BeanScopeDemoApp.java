package com.guba.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guba.spring.interfaces.Coach;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
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
