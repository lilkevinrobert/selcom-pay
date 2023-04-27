package com.example.selcompay.controller;

import com.example.selcompay.model.Secret;
import com.example.selcompay.util.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class TestController {


    private final WebClient webClient;
    private final String consumerKey = "a3LGqfaFkfSQeB56u0SB2ETN9V40GC78";
    private final String ConsumerSecret = "j58OOsw5bOpXYuWFE29OOHs9XAc=";

    @Autowired
    public TestController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping(name = "test", path = "/test")
    public String test() {
        return "test";
    }

    @PostMapping("/authentication")
    public AuthenticationResponse authentication(@RequestBody Secret secret) {

        return webClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/Auth/RequestToken")
                        .queryParam("consumer_key", secret.getConsumer_key())
                        .queryParam("consumer_secret", secret.getConsumer_secret())
                        .build()
                )
                .retrieve()
                .bodyToMono(AuthenticationResponse.class)
                .block();
    }
}
