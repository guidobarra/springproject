package com.guba.spring.implement;

import org.springframework.beans.factory.annotation.Value;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

public class SwimCoach implements Coach {
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	private FortuneService fortuneSerevice;
	
	public SwimCoach(FortuneService fortuneSerevice) {
		this.fortuneSerevice = fortuneSerevice;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneSerevice.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

}
