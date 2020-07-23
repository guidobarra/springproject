package com.guba.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.guba.spring.implement.HappyFortuneService;
import com.guba.spring.implement.SwimCoach;
import com.guba.spring.interfaces.Coach;
import com.guba.spring.interfaces.FortuneService;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfigNoXml {
	
	// define bean for our sad fortune service
	@Bean //name happyFortuneService is ID the bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean //name swimCoach is ID the bean
	public Coach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(happyFortuneService());
		
		return mySwimCoach;
	}
}
