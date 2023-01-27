package com.websocket.gis.config;

import com.websocket.gis.Controller.CommunicationController;
import com.websocket.gis.entity.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketEventListener {
    private  static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @EventListener
    public void handleWebSocketConnectListener(SessionDisconnectEvent event){
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebsockerDisconnectListener(SessionDisconnectEvent event){
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            //remove user from latest Location Feed
            CommunicationController.latestLocationFeed.remove(username);

            //transmitting current user's latest location feed
            messagingTemplate.convertAndSend("/app/getData", new Location());
        }
    }
}
