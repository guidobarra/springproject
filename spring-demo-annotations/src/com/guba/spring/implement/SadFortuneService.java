package com.guba.spring.implement;

import com.guba.spring.interfaces.FortuneService;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a sad day";
	}

}
