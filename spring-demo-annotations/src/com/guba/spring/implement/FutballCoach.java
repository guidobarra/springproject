package com.guba.spring.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

@Component
public class FutballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// define a default constructor
	public FutballCoach() {
		super();
		System.out.println("FutballCoach: inside default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice 4 hours with ball";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune() + FutballCoach.class;
	}

	// define a setter method, the name method setter can be other ej "doSomeCrazyStuff"
	@Autowired
	public void setFortuneService(@Qualifier("happyFortuneService") FortuneService fortuneService) {
		System.out.println("FutballCoach: inside setFortuneService() method");
		this.fortuneService = fortuneService;
	}

}
