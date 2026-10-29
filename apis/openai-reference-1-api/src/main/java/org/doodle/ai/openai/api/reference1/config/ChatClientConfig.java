package org.doodle.ai.openai.api.reference1.config;

import com.openai.models.ChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SafeGuardAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.List;

@Configuration
public class ChatClientConfig {

    @Value("classpath:promptTemplates/systemPromptTemplate.st")
    private Resource systemPromptTemplate;

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder) {
        List<Advisor> advisors = List.of(
                new SimpleLoggerAdvisor(),
                new SafeGuardAdvisor(List.of("bastard", "idiot", "stupid", "dumb", "fool", "moron"))
        );
        OpenAiChatOptions.Builder options = OpenAiChatOptions.builder()
                .model(ChatModel.GPT_4O_MINI.asString())
                .maxTokens(500)
                .temperature(0.7)
                .topP(0.9)
                .frequencyPenalty(0.5);
        return chatClientBuilder
                .defaultAdvisors(advisors)
                .defaultOptions(options)
                .defaultSystem(systemPromptTemplate)
                .defaultUser("How can I assist you today?")
                .build();
    }


}
