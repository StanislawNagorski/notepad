package com.sda.training.zoo.animals;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Snake implements Raptile{
	@Override
	public String raptileSound() {
		return "SSSSSSSS - snake";
	}
}
