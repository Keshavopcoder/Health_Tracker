package com.htps.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        logger.info("Registering WebSocket endpoint: /ws");

        registry.addEndpoint("/ws")
                .setAllowedOrigins("http://localhost:5173") // Allow React frontend
                .withSockJS(); // Enable SockJS fallback for browsers without WebSocket support
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        logger.info("Configuring message broker...");

        registry.enableSimpleBroker("/topic", "/queue"); // Allows messaging with topics and queues
        registry.setApplicationDestinationPrefixes("/app"); // Prefix for messages sent from client
        registry.setUserDestinationPrefix("/user"); // Enables private messaging for users
    }
}

