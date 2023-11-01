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
    public OutGoingMessage broadCastMessage(IncomingMessage message){
        System.out.println("message received");
        return new OutGoingMessage("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

//    @MessageMapping("/session_chat")
//    public OutGoingMessage privateMessage(IncomingMessage message){
//        simpleMessagingTemplate.convertAndSendToUser();
//    }

}
