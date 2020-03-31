package com.monmouthvalley.tandoor.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = {"http://localhost:3000", "https://tandoor.netlify.com", "http://tandoor.s3-website-us-east-1.amazonaws.com"})
public class WebSocketController {

    private SimpMessagingTemplate template;


    @Autowired
    public WebSocketController(SimpMessagingTemplate simpMessagingTemplate){
        this.template = simpMessagingTemplate;
    }

    /*once this url is triggered, we will send a message
    to clients subscribed to the notification endpoint*/

    //TO-DO: SO each time the order enpoint is call we need to all call this endpoint
    // to provide notication about the order

    @MessageMapping("/notify")
    public void orderNotification(String message){
        this.template.convertAndSend("/notification", message);
    }
}
