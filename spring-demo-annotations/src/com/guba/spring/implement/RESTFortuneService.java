package com.guba.spring.implement;

import org.springframework.stereotype.Component;

import com.guba.spring.interfaces.FortuneService;

@Component
public class RESTFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "";
	}

}
