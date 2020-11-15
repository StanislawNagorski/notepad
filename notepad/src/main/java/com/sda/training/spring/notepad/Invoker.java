package com.sda.training.spring.notepad;


import java.time.LocalDateTime;

import com.sda.training.spring.notepad.models.Note;
import com.sda.training.spring.notepad.repositories.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Invoker implements CommandLineRunner {
	private final NoteRepository noteRepository;

	@Override
	public void run(String... args) throws Exception {
		Note sampleNote = new Note();
		sampleNote.setTitle("Sample title");
		sampleNote.setContent("Lorem ipsum ...");
		sampleNote.setCreationTime(LocalDateTime.now());
		sampleNote.setUpdateTime(LocalDateTime.now());

		noteRepository.save(sampleNote);
	}
}
