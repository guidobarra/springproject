package com.guba.spring;

import org.springframework.stereotype.Component;

@Component
public class DataBaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Fortune Database is not found";
	}

}
