package com.sda.training.zoo.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
//	DO NOT USE
//	@Autowired
	private Wheel wheel;

//	@Autowired
	public Car(Wheel wheel) {
		this.wheel = wheel;
	}

//	public Car(Wheel wheel, Door door) {
//		this.wheel = wheel;
//	}

//	@Autowired
//	public void setWheel(Wheel wheel) {
//		this.wheel = wheel;
//	}
}
