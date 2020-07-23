package com.guba.spring.implement;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

public class GolfCoach implements Coach {

	private FortuneService fortuneService;
	
	public GolfCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
