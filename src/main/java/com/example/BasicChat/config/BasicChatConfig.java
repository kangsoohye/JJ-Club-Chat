package com.example.BasicChat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BasicChatConfig {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
