package com.sda.training.spring.notepad.services.decorators;

import org.springframework.stereotype.Component;

@Component
public class FrameAppender implements ContentModifier {
	private static final String FRAME = "**";

	public String execute(String content){
		StringBuilder sb = new StringBuilder();
		if(!content.startsWith(FRAME)) {
			sb.append(FRAME);
		}
		sb.append(content);
		if(!content.endsWith(FRAME)) {
			sb.append(FRAME);
		}

		return sb.toString();
	}
}
