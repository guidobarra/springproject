package com.guba.spring.implement;

import org.springframework.beans.factory.DisposableBean;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

public class TrackCoach implements Coach, DisposableBean /**destroy scope prototype**/ {
	
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
	
	// add an init method
	public void doMyStartupStuffInit() {
		System.out.println("TranckCoach; inside method doMyStartupStuffInit");
	}
	
	// add a destroy method scope singleton
	public void doMyStartupStuffDestroy() {
		System.out.println("TranckCoach; inside method doMyStartupStuffDestroy scope singleton");
	}

	// add a destroy method scope prototype
	@Override
	public void destroy() throws Exception {
		System.out.println("TranckCoach; inside method doMyStartupStuffDestroy scope prototype");
	}
	
	
}
