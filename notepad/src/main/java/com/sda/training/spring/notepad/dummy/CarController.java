package com.sda.training.spring.notepad.dummy;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CarController {
	private final CarService carService;

	public void gmm(){
		carService.random();
	}
}
