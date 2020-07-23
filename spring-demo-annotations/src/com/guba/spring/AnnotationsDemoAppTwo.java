package com.guba.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationsDemoAppTwo {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container, default bean id is the name class impl
		Coach theCoach = context.getBean("tennisCoachTwo", Coach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// close context
		context.close();
	}

}
