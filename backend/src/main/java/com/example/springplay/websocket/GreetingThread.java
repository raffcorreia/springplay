package com.example.springplay.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class GreetingThread extends Thread {

    private SimpMessagingTemplate messageTemplate;
    private String topic;

    public GreetingThread() {
    }

    public GreetingThread(SimpMessagingTemplate messageTemplate, String topic) {
        this.messageTemplate = messageTemplate;
        this.topic = topic;
    }


    public void run() {
        long startTime = System.currentTimeMillis();
        int i = 5;
        while (i > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(this.getName() + ": New Thread is running..." + i);
            messageTemplate.convertAndSend(topic, new Greeting("server", "A message back from your thread: " + i));

            i--;
        }
    }
}
