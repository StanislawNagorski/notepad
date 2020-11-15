package com.sda.training.spring.notepad.analys;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Rates {
    @JsonProperty("EUR")
    private double eur;
    @JsonProperty("USD")
    private double usd;
    @JsonProperty("GBP")
    private double gbp;
}
