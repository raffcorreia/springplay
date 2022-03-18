package com.bot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;


public class StompSessionHandler extends StompSessionHandlerAdapter {
    private final Logger logger = LogManager.getLogger(StompSessionHandler.class);

    public static final String TOPIC_GREETINGS = "/topic/greetings";

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        logger.info("New session established : " + session.getSessionId());
        session.subscribe(TOPIC_GREETINGS, this);
        logger.info("Subscribed to /topic/greetings");
        session.send(TOPIC_GREETINGS, getSampleMessage());
        logger.info("Message sent to websocket server");
    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        logger.error("Got an exception", exception);
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Message.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Message msg = (Message) payload;
        logger.info("Received : " + msg.getContent());
    }

    public StompSessionHandler() {
        super();
        logger.info("Constructor...");
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        logger.info("handleTransportError...");
        super.handleTransportError(session, exception);
    }

    private Message getSampleMessage() {
        Message msg = new Message();
        msg.setUser("boot");
        msg.setContent("This is the Spring client!");
        return msg;
    }
}