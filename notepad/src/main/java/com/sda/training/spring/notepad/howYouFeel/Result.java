package com.sda.training.spring.notepad.howYouFeel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
    private double polarity;
    private String type;
}
