package com.monmouthvalley.tandoor.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //clients will connect through this "/sockets endpoint
            registry.addEndpoint("/sockets")
                    .setAllowedOrigins("*")
                    .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
            //clients will need to subscribe to this "/notification" endpoint
            //and wait for the server's order repsonse

            registry.setApplicationDestinationPrefixes("/app")
                    .enableSimpleBroker("/notifications");
    }
}
