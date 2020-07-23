package com.guba.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guba.spring.config.SportConfig;
import com.guba.spring.interfaces.Coach;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		System.out.println("\nSTART create beans");
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		System.out.println("\nEND create beans");
		
		// get the bean from spring container, default bean id is the name class impl
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach theCoachTwo = context.getBean("futballCoach", Coach.class);
		Coach theCoachTrhee = context.getBean("voleyCoach", Coach.class);
		
		// call a method on the bean
		System.out.println("\nDependency Injection in Constructor");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println("\nDependency Injection in setter");
		System.out.println(theCoachTwo.getDailyWorkout());
		System.out.println(theCoachTwo.getDailyFortune());
		System.out.println("\nDependency Injection in attribute");
		System.out.println(theCoachTrhee.getDailyWorkout());
		System.out.println(theCoachTrhee.getDailyFortune());
		
		// close context
		context.close();
	}

}
