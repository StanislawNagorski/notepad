package com.sda.training.zoo.animals;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Lizard implements Raptile{

	@Override
	public String raptileSound() {
		return "sy sy sy - lizard";
	}
}
