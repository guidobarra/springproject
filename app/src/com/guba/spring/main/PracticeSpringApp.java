package com.guba.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.guba.spring.implement.GolfCoach;
import com.guba.spring.interfaces.Coach;

public class PracticeSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file 
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContextPractice.xml");
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myGolfCoach", GolfCoach.class);
		
		// call methods on the bean
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getDailyWorkout());
		
		// close context
		context.close();
	}

}
