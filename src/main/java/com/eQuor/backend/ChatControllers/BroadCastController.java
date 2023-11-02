package com.eQuor.backend.ChatControllers;

import com.eQuor.backend.ChatModels.IncomingMessage;
import com.eQuor.backend.ChatModels.OutGoingMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

@Controller
@CrossOrigin
public class BroadCastController {


    @Autowired
    SimpMessagingTemplate simpleMessagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public IncomingMessage broadCastMessage(IncomingMessage message){
        System.out.println("message received");


        return message;
    }

    @MessageMapping("/session_chat")
    public IncomingMessage privateMessage(IncomingMessage message){
        simpleMessagingTemplate.convertAndSendToUser(message.getReceiver(), "/private", message);
        return message;
    }

}
