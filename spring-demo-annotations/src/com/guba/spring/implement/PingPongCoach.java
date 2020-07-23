package com.guba.spring.implement;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

@Component
@Scope("prototype")
public class PingPongCoach implements Coach, DisposableBean /**destroy scope prototype**/{

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService forutneService;
	
	@Override
	public String getDailyWorkout() {
		return "Practice Ping ping wich your friends by 4 Hours";
	}

	@Override
	public String getDailyFortune() {
		return forutneService.getFortune();
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("PingPongCoach: method PostConstruct, name: doMyStartupStuff()");
	}
	
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("PingPongCoach: method PreDestroy scope singleton, name: doMyCleanupStuff()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("PingPongCoach: method PreDestroy scope prototype, name: destroy()");
	}
}
