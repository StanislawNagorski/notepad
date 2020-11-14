package com.sda.training.spring.notepad;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

//URL
//>
//CONTROLLER
//>
//SERVICE
//>
//REPOSITORY
//>
//DB


@Service
@RequiredArgsConstructor
public class NoteService {
	private final NoteRepository noteRepository;
//	private final FrameAppender frameAppender;
	private final List<ContentModifier> modifiers;

	public Optional<Note> save(Note note){
		if (note.getId() != null && noteRepository.findById(note.getId()).isPresent()){
			return Optional.empty();
		}
		note.setContent(modify(note));

//		note.setContent(frameAppender.execute(note.getContent()));
		return Optional.of(noteRepository.save(note));
	}

	private String modify(Note note) {
		String finalContent = note.getContent();
		for (ContentModifier modifier : modifiers) {
			finalContent = modifier.execute(finalContent);
		}
		return finalContent;
	}

	public List<Note> findAll(){
		return noteRepository.findAll();
	}

	public Optional<Note> update(Long id, Note note){
		Optional<Note> byId = noteRepository.findById(id);
		if(byId.isEmpty()){
			return byId;
		}
		Note noteFromDb = byId.get();
		noteFromDb.setTitle(note.getTitle());
		noteFromDb.setContent(note.getContent());
		noteFromDb.setUpdateTime(note.getUpdateTime());
		noteFromDb.setCreationTime(note.getCreationTime());

		note.setContent(modify(note));
		return Optional.of(noteRepository.save(noteFromDb));
	}

	public Optional<Note> findById(Long id){
		return noteRepository.findById(id);
	}

	public Optional<Note> delete(Long id){
		Optional<Note> byId = noteRepository.findById(id);
		if(byId.isEmpty()){
			return byId;
		}
		noteRepository.deleteById(id);
		return byId;
	}

	public List<Note> findByTitleAndContentContains(String title, String content){
		return noteRepository.findByTitleAndContentContains(title, content);
	}

}
