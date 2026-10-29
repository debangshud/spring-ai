package org.doodle.ai.openai.api.reference2.config;

import org.doodle.ai.openai.api.reference2.advisor.TokenUsageAuditAdvisor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        return chatClientBuilder
                .defaultSystem("""
                        You're a helpful assistant for answering questions related to Human Resources. 
                        You will be provided with questions, and you should provide clear and concise answers based on your knowledge of HR policies, procedures, and best practices.
                        """)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultAdvisors(new SafeGuardAdvisor(List.of("bastard", "idiot", "stupid", "dumb", "fool", "moron")))
                .defaultAdvisors(new TokenUsageAuditAdvisor())
                .build();
    }
}
