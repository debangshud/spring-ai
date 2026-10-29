package org.doodle.ai.openai.api.reference3.service;

import lombok.RequiredArgsConstructor;
import org.doodle.ai.openai.api.reference3.model.Country;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Reference3Service {

    private final ChatClient chatClient;

    public List<Country> getCountries() {
        return chatClient.prompt()
//                .system(promptSystemSpec -> promptSystemSpec.text("You are a helpful assistant that provides a list of countries with their details."))
                .user("Please provide a list of 25 countries with their name, alpha2Code, alpha3Code, and dialCode in JSON format.")
                .call()
                .entity(new ParameterizedTypeReference<List<Country>>() {
                });
    }
}
