package com.guba.spring.implement;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

public class BaseBallCoach implements Coach{

	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseBallCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public BaseBallCoach() {
		super();
	} 
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get fortune
		return this.fortuneService.getFortune();
	}
	
	
}
