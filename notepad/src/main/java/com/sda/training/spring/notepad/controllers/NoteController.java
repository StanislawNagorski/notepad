package com.sda.training.spring.notepad.controllers;

import java.util.List;
import java.util.Optional;

import com.sda.training.spring.notepad.services.exepction.NoteCreationException;
import com.sda.training.spring.notepad.models.Note;
import com.sda.training.spring.notepad.services.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/v0/api/notes")
public class NoteController {
	private final NoteService noteService;

	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
//	@ResponseBody
	public String helloWorld(){
		return "hello World!";
	}

	@GetMapping("/{id}")
//	public Note sample(@PathVariable(name = "id") Long identificationNumber){
	public ResponseEntity<Note> getById(@PathVariable Long id){
		Optional<Note> byId = Optional.ofNullable(noteService.findById(id));
		if(byId.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.build();
		}
		return ResponseEntity.ok(byId.get());
	}

//	@RequestMapping(value = "/api/note/getall", method = RequestMethod.GET)
	@GetMapping
//	@ResponseBody
	public List<Note> getAllNotes(){
		return noteService.findAll();
	}

	@PostMapping
	public ResponseEntity<Note> save(@RequestBody Note note){
////		UUID uuid = UUID.randomUUID();
//		if(note.getId() != null && noteRepository.findById(note.getId()).isPresent()) {
//			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
//				   .build();
//		}
//
////		if(noteFromDb.isPresent()){
////			throw new RuntimeException("Note already exists!");
////		}
//		note.setContent(frameAppender.execute(note.getContent()));
//
//		return ResponseEntity.status(HttpStatus.CREATED)
//				.body(noteRepository.save(note));

		Optional<Note> save = null;
		try {
			save = Optional.ofNullable(noteService.save(note));
		} catch (NoteCreationException e) {
			e.printStackTrace();
		}
		if(save.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					   .build();
		}
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(save.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Note> delete(@PathVariable Long id){
		Optional<Note> byId = Optional.ofNullable(noteService.findById(id));
		if(byId.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					   .build();
		}
		noteService.delete(id);
		return ResponseEntity.ok(byId.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Note> update(@PathVariable Long id, @RequestBody Note note){
//		Optional<Note> byId = noteRepository.findById(id);
//		if(byId.isEmpty()){
//			return ResponseEntity.status(HttpStatus.NOT_FOUND)
//					   .build();
//		}
//		Note noteFromDb = byId.get();
//		noteFromDb.setTitle(note.getTitle());
//		noteFromDb.setContent(note.getContent());
//		noteFromDb.setUpdateTime(note.getUpdateTime());
//		noteFromDb.setCreationTime(note.getCreationTime());
//
//		noteFromDb.setContent(frameAppender.execute(noteFromDb.getContent()));
//		return ResponseEntity.ok(noteRepository.save(noteFromDb));

		Optional<Note> update = Optional.ofNullable(noteService.update(id, note));
		if(update.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					   .build();
		}
		return ResponseEntity.ok(update.get());
	}

	@GetMapping("/filter")
	public List<Note> filter(@RequestParam(required = false) String title, @RequestParam String content){
		return noteService.findByTitleAndContentContains(title, content);
	}
}
