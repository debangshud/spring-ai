package org.doodle.ai.openai.api.reference2.controller;

import lombok.RequiredArgsConstructor;
import org.doodle.ai.openai.api.reference2.service.Reference2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/openai/reference2")
public class Reference2Controller {

    private final Reference2Service service;

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam("message") String message) {
        return ResponseEntity.ok(service.chat(message));
    }
}
