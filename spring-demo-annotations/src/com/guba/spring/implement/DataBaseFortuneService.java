package com.guba.spring.implement;

import org.springframework.stereotype.Component;

import com.guba.spring.interfaces.FortuneService;

@Component
public class DataBaseFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Fortune Database is not found";
	}

}
