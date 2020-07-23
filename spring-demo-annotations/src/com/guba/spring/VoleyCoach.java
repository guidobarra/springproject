package com.guba.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class VoleyCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

	public VoleyCoach() {
		super();
		System.out.println("VoleyCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice 2 hours";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune() + VoleyCoach.class;
	}

}
