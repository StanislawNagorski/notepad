package com.sda.training.spring.notepad.services.decorators;

public interface ContentModifier {
	String execute(String content);
}
