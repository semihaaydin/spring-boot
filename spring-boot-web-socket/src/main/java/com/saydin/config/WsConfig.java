package com.saydin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //Mesaj Gönderdiğimiz kısım, sunucu yayınladık
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
        // Endpoint yayınladık, Bu endpoin
        //.setAllowedOrigins("*"). => heryerden istek gelebilir.
        //.withSockJS() => sockJS enable edilir.
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //Mesaj dinlediğimiz kısım, mesajı dinledik
        registry.enableSimpleBroker("/topic");
    }
}
