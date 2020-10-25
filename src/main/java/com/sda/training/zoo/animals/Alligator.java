package com.sda.training.zoo.animals;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Alligator implements Raptile{
	@Override
	public String raptileSound() {
		return "czlap czlap - Alligator";
	}
}
