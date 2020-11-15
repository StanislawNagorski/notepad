package com.sda.training.spring.notepad.RandomNumber;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope("singleton") //singleton jest defoltowy
//sessionScope zyje razem z użytownikiem
//requestscope nowy z każdym requestem
public class SingletonNumberGEnerator {

    private final Integer random;

    public SingletonNumberGEnerator() {
        random = new Random().nextInt();
    }

    public Integer generate(){
        return random;
    }
}
