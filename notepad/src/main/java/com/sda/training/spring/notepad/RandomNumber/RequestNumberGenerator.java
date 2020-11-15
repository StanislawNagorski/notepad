package com.sda.training.spring.notepad.RandomNumber;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Random;

@Component
@RequestScope
public class RequestNumberGenerator {

    private final Integer random;

    public RequestNumberGenerator() {
        random = new Random().nextInt();
    }

    public Integer generate(){
       return random;
    }
}
