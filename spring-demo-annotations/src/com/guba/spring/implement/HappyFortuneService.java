package com.guba.spring.implement;

import org.springframework.stereotype.Component;

import com.guba.spring.interfaces.FortuneService;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day!";
	}

}
