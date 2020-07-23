package com.guba.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.guba.spring.config.SportConfigNoXml;
import com.guba.spring.implement.SwimCoach;

public class JavaConfigDemoNoXmlApp {

	public static void main(String[] args) {
		System.out.println("\nSTART create beans");
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfigNoXml.class);
		System.out.println("\nEND create beans");
		
		// get the bean from spring container, default bean id is the name class impl
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		
		// call a method on the bean
		System.out.println("\nDependency Injection in Constructor");
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("team: " + theCoach.getTeam());
		System.out.println("email: " + theCoach.getEmail());;
		// close context
		context.close();
	}

}
