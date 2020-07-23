package com.guba.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoApp {

	public static void main(String[] args) {
		System.out.println("\nSTART create beans");
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
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
