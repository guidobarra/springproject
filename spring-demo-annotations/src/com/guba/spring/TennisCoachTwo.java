package com.guba.spring;

import org.springframework.stereotype.Component;

@Component()
public class TennisCoachTwo implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
