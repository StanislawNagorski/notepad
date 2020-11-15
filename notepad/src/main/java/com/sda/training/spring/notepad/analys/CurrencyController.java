package com.sda.training.spring.notepad.analys;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    public static final String URL = "https://api.exchangeratesapi.io/latest?base=PLN";
    public static final String URL_1 = "http://api.nbp.pl/api/exchangerates/tables/A/?format=json";

    @GetMapping
    public Rates callForCurrency() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        Currency currency = restTemplate.getForObject(URL, Currency.class);
        return currency.getRates();
    }

}
