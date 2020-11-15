package com.sda.training.spring.notepad.services.exepction;

public class NoteCreationException extends RuntimeException{

    public NoteCreationException(String message) {
        super(message);
    }
}
