package com.example.springplay.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    public static final String TOPIC_GREETINGS = "/topic/greetings";

    @Autowired
    private SimpMessagingTemplate messageTemplate;

    @MessageMapping("/hello")
    @SendTo(TOPIC_GREETINGS)
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay

        GreetingThread greetingThread = new GreetingThread(messageTemplate, TOPIC_GREETINGS);
        greetingThread.start();

        return new Greeting("server", "Hello, " + HtmlUtils.htmlEscape(message.name()) + "!");
    }
}
