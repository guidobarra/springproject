package com.guba.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guba.spring.interfaces.Coach;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(alphaCoach.getDailyWorkout());
		
		// clsoe the context
		context.close();
	}

}
