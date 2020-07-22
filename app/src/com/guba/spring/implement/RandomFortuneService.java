package com.guba.spring.implement;

import java.util.Random;

import com.guba.spring.interfaces.FortuneService;

public class RandomFortuneService implements FortuneService {
	
	String array[] = {
			"Your fortune very Good!!", 
			"Your fortune Good!!",
			"Your fortune Bad!!"
			};
	
	Random random = new Random();

	@Override
	public String getFortune() {
		int index = random.nextInt(array.length);
		return array[index];
	}

}
