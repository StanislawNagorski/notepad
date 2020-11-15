package com.sda.training.spring.notepad.howYouFeel;

import com.sda.training.spring.notepad.analys.Currency;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/feeling")
public class FeelController {
    public static final String URL = "https://sentim-api.herokuapp.com/api/v1/";

    @PostMapping
    public FeelResult callForFeelings(){
        FeelingRequest feelingRequest1 = new FeelingRequest();
        feelingRequest1.setText("i fucking hate you");

        RestTemplate restTemplate = new RestTemplate();
        FeelResult result = restTemplate.postForObject(URL,feelingRequest1, FeelResult.class);

        return result;
    }
}
