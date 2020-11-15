package com.sda.training.spring.notepad.controllers;

import com.sda.training.spring.notepad.services.exepction.ApiError;
import com.sda.training.spring.notepad.services.exepction.NoteCreationException;
import com.sda.training.spring.notepad.models.Note;
import com.sda.training.spring.notepad.services.NoteService;
import com.sda.training.spring.notepad.services.exepction.NoteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/notes")
public class NoteControllerV1 {
    private final NoteService noteService;

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public String helloWorld() {
        return "hello World!";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Note getById(@PathVariable Long id) {
        return noteService.findById(id);
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Note save(@Valid @RequestBody Note note) {
        return noteService.save(note);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Note update(@PathVariable Long id, @RequestBody Note note) {
        return noteService.update(id, note);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Note delete(@PathVariable Long id) {
        return noteService.delete(id);
    }

    @GetMapping("/filter")
    public List<Note> filter(@RequestParam(required = false) String title, @RequestParam String content) {
        return noteService.findByTitleAndContentContains(title, content);
    }

    //@ExceptionHandler({NoteCreationException.class, NoteNotFoundException.class})//przyjmuje tez tablice
    @ExceptionHandler(NoteCreationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError noteCreationExceptionHandler(RuntimeException runtimeException){
        return new ApiError(UUID.randomUUID(), runtimeException.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError constrainsExceptionsHandler(MethodArgumentNotValidException exception){
        return new ApiError(UUID.randomUUID(),
                exception.getMessage() + " : " +exception.getParameter(),
                LocalDateTime.now());
    }

}
