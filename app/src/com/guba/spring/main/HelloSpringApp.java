package com.guba.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guba.spring.implement.TrackCoach;
import com.guba.spring.interfaces.Coach;

public class HelloSpringApp {

	public static void main(String[] args) {
	
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", TrackCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// let's ccall our new method for fortunes
		System.out.println(theCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}
