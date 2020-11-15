package com.sda.training.spring.notepad.services;

import java.util.List;
import java.util.Optional;

import com.sda.training.spring.notepad.Roles;
import com.sda.training.spring.notepad.services.decorators.ContentModifier;
import com.sda.training.spring.notepad.services.exepction.NoteCreationException;
import com.sda.training.spring.notepad.models.Note;
import com.sda.training.spring.notepad.repositories.NoteRepository;
import com.sda.training.spring.notepad.services.exepction.NoteNotFoundException;
import com.sda.training.spring.notepad.services.loggers.CustomLogger;
import org.springframework.security.access.annotation.Secured;
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
	private final List<ContentModifier> modifiers;
	private final CustomLogger logger;

	@Secured("ROLE_ADMIN")
	public Note save(Note note) throws NoteCreationException {
		logger.log("save of ", String.valueOf(note.getId()));
		if (note.getId() != null && noteRepository.findById(note.getId()).isPresent()){
			throw new NoteCreationException("Cannot save note with id:" + note.getId());
		}
		note.setContent(modify(note));

		return noteRepository.save(note);
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

	public Note update(Long id, Note note){
		Optional<Note> byId = noteRepository.findById(id);
		if(byId.isEmpty()){
			throw new NoteCreationException("Cannot modify note with id:" + note.getId());
		}
		Note noteFromDb = byId.get();
		noteFromDb.setTitle(note.getTitle());
		noteFromDb.setContent(note.getContent());
		noteFromDb.setUpdateTime(note.getUpdateTime());
		noteFromDb.setCreationTime(note.getCreationTime());

		note.setContent(modify(note));
		return noteRepository.save(noteFromDb);
	}

	public Note findById(Long id){
		Optional<Note> byId = noteRepository.findById(id);
		if (byId.isEmpty()){
			throw new NoteNotFoundException("Note not found id:" + id);
		}
		return byId.get();
	}

	public Note delete(Long id){
		Optional<Note> byId = noteRepository.findById(id);
		if(byId.isEmpty()){
			throw new NoteNotFoundException("Note not found id:" + id);
		}
		noteRepository.deleteById(id);
		return byId.get();
	}

	public List<Note> findByTitleAndContentContains(String title, String content){
		return noteRepository.findByTitleAndContentContaining(title, content);
	}

}
