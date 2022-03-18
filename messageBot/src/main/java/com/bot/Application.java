package com.bot;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        System.out.println("Starting STOMP client...");

        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);

        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        WebSocketHttpHeaders handshakeHeaders = new WebSocketHttpHeaders();
        handshakeHeaders.add(HttpHeaders.AUTHORIZATION, "Basic YWRtaW46YWRtaW4=");

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        System.out.println("It is going to connect...");
        ListenableFuture<StompSession> session = stompClient.connect(URL, handshakeHeaders,sessionHandler);

        System.out.printf("Connection is running %s \n", stompClient.isRunning());
        System.out.printf("Session is done %s \n", session.isDone());

        new Scanner(System.in).nextLine(); // Don't close immediately.
    }
}
