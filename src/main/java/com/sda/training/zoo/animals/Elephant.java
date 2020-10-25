package com.sda.training.zoo.animals;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Elephant implements Animal{
	private static final String ELEPHANT_SOUND = "truuuuuu - elephant";

	@Override
	public String sound(){
		return ELEPHANT_SOUND;
	}
}
