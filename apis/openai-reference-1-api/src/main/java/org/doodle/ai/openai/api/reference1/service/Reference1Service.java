package org.doodle.ai.openai.api.reference1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Reference1Service {
    @Value("classpath:promptTemplates/userPromptTemplate.st")
    private Resource userPromptTemplate;
    private final ChatClient chatClient;

    public String chat(String name, String message) {
        return chatClient.prompt()
                .user(promptUserSpec -> promptUserSpec.text(userPromptTemplate)
                        .param("name", name)
                        .param("message", message))
                .call()
                .content();
    }
}
