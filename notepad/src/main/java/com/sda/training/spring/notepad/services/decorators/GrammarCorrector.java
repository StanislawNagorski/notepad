package com.sda.training.spring.notepad.services.decorators;

import org.springframework.stereotype.Component;

@Component
public class GrammarCorrector implements ContentModifier {
	public String execute(String content){
		return content;
	}
}
