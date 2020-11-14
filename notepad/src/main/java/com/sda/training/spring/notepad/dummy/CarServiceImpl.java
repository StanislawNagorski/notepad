package com.sda.training.spring.notepad.dummy;

import org.springframework.stereotype.Component;

@Component
public class CarServiceImpl implements CarService {
	public int random(){
		//wylosowany przez uczciwy rzut kostką
		return 3;
	}
}
