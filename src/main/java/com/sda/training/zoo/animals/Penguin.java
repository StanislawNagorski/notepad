package com.sda.training.zoo.animals;

import org.springframework.stereotype.Component;

@Component
public class Penguin implements Animal{
	@Override
	public String sound() {
		return "srututututu - penguin 🐧";
	}
}
