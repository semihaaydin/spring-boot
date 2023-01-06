package com.saydin.api;

import com.saydin.model.WSMessage;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate; //Mesajlaşmayı özelleştirmek için kullanırız.

    @MessageMapping("/chat")
    public void chatEndpoint(@Payload WSMessage message){
            System.out.println(message);
        messagingTemplate.convertAndSend("/topic",message);
    }
}
