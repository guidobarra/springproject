package com.guba.spring.implement;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

public class TrackCoach implements Coach {
	
	// define a private field for the dependency
	private FortuneService fortuneService;
		
	// define a constructor for dependency injection
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public TrackCoach() {
		super();
	} 
		
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get fortune
		return "Just Do It: " + this.fortuneService.getFortune();
	}
	
}
