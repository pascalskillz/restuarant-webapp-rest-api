package com.monmouthvalley.tandoor.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private SimpMessagingTemplate template;


    @Autowired
    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate){
        this.template = simpMessagingTemplate;
    }

    @MessageMapping
    public void orderNotification(String message){
        this.template.convertAndSend("/notification", message);
    }
}
