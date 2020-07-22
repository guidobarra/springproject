package com.guba.spring.implement;

import com.guba.spring.interfaces.FortuneService;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
