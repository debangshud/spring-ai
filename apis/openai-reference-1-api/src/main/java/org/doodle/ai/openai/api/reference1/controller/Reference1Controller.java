package org.doodle.ai.openai.api.reference1.controller;

import lombok.RequiredArgsConstructor;
import org.doodle.ai.openai.api.reference1.service.Reference1Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/openai/reference1")
public class Reference1Controller {
    private final Reference1Service reference1Service;
    @GetMapping("/chat")
    public String chat(@RequestParam("name") String name, @RequestParam("message") String message) {
        return reference1Service.chat(name, message);
    }
}
