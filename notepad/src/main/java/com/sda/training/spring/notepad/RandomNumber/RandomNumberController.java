package com.sda.training.spring.notepad.RandomNumber;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/random")
public class RandomNumberController {

    private final SingletonNumberGEnerator singletonNumberGEnerator;
    private final RequestNumberGenerator requestNumberGenerator;

    @GetMapping("/singleton")
    public Integer singletonRandom(){
        return singletonNumberGEnerator.generate();
    }

    @GetMapping("/request")
    public Integer requestRandom(){
        return requestNumberGenerator.generate();
    }

}
