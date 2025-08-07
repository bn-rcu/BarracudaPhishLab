package com.hackathon.phishing_simulator.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/api/ai")
public class AiProxyController {

    private static final String OPENAI_API_URL = "https://api.sage.cudasvc.com/openai/chat/completions";
    private static final String OPENAI_API_TOKEN = "YOUR_TOKEN_HERE"; // Replace with your valid token

    @PostMapping("/chat/completions")
    public ResponseEntity<String> proxyChatCompletions(@RequestBody Map<String, Object> payload) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(OPENAI_API_TOKEN);
        headers.setAccept(java.util.Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(OPENAI_API_URL, entity, String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}