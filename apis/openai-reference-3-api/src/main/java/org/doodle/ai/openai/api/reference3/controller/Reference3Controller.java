package org.doodle.ai.openai.api.reference3.controller;

import lombok.RequiredArgsConstructor;
import org.doodle.ai.openai.api.reference3.model.Country;
import org.doodle.ai.openai.api.reference3.service.Reference3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/openai/reference3")
public class Reference3Controller {

    private final Reference3Service reference3Service;

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getCountries(){
        return ResponseEntity.ok(reference3Service.getCountries());
    }
}
