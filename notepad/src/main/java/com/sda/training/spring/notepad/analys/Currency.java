package com.sda.training.spring.notepad.analys;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Currency {
    private Rates rates;
    private String base;
    private String date;

}
