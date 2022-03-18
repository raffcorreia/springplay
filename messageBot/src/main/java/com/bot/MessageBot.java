package com.bot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

public class MessageBot {
    private static final Logger logger = LogManager.getLogger(MessageBot.class);

    private static final String URL = "ws://localhost:8080/api/stomp";

    public static void main(String[] args) {
        System.out.println("Starting STOMP client...");

        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        WebSocketHttpHeaders handshakeHeaders = new WebSocketHttpHeaders();
        handshakeHeaders.add(HttpHeaders.AUTHORIZATION, "Basic Ym9vdDpib290");

        org.springframework.messaging.simp.stomp.StompSessionHandler sessionHandler = new StompSessionHandler();
        logger.info("It is going to connect...");
        ListenableFuture<StompSession> session = stompClient.connect(URL, handshakeHeaders, sessionHandler);

        logger.info("Connection is running {}", stompClient.isRunning());
        logger.info("Session is done {}", session.isDone());

        new Scanner(System.in).nextLine(); // Don't close immediately.
    }
}
