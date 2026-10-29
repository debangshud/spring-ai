package org.doodle.ai.openai.api.reference2.service;

import lombok.RequiredArgsConstructor;
import org.doodle.ai.openai.api.reference2.advisor.TokenUsageAuditAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Reference2Service {
    @Value("classpath:promptTemplates/systemPromptTemplate.st")
    private Resource systemPromptTemplate;

    private final ChatClient chatClient;

    public String chat(String message) {
        return chatClient.prompt()
                .system(promptSystemSpec -> promptSystemSpec.text(systemPromptTemplate))
                .user(message).call().content();
    }
}
