package com.sda.training.spring.notepad;

import org.springframework.stereotype.Component;

@Component
public class GrammarCorrector implements ContentModifier{
	public String execute(String content){
		return content;
	}
}
