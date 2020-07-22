package com.guba.spring.main;

import com.guba.spring.implement.TrackCoach;
import com.guba.spring.interfaces.Coach;

public class MyApp {

	public static void main(String[] args) {
		
		Coach theCauch = new TrackCoach();
		System.out.println(theCauch.getDailyWorkout());
	}

}
