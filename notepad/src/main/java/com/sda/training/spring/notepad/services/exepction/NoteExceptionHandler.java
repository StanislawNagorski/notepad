package com.sda.training.spring.notepad.services.exepction;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class NoteExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    public ApiError noteNoteFoundHandler(RuntimeException runtimeException){
        return new ApiError(UUID.randomUUID(), runtimeException.getMessage(), LocalDateTime.now());
    }
}
