package com.eQuor.backend.ChatControllers;

import com.eQuor.backend.ChatModels.IncomingMessage;
import com.eQuor.backend.ChatModels.OutGoingMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class BroadCastController {


    @MessageMapping("/hello")
    @SendTo("/topic/hello")
    public OutGoingMessage broadCastMessage(IncomingMessage message){
        System.out.println(message.getMessage());
        return new OutGoingMessage(message.getMessage());
    }

}
