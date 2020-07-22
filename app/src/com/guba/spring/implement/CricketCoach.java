package com.guba.spring.implement;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	// inyection values
	private String emailAddress;
	
	private String team;
	
	public CricketCoach() {
		super();
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	// setter inyection depencias
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method");
		this.fortuneService = fortuneService;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}
	
	// setter inyection values
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method - setEmailAddres");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method - setTeam");
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
