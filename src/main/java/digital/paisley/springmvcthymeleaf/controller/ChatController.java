package digital.paisley.springmvcthymeleaf.controller;

import digital.paisley.springmvcthymeleaf.model.ChatUser;
import digital.paisley.springmvcthymeleaf.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/user")
    @SendTo("/topic/user")
    public Message getMessage(ChatUser user){

        return new Message("hello "+ user.getName());

    }

}
