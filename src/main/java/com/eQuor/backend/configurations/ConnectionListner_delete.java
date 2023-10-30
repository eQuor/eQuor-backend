package com.eQuor.backend.configurations;



import org.springframework.context.ApplicationListener;
        import org.springframework.stereotype.Component;
        import org.springframework.web.socket.messaging.SessionConnectedEvent;

import java.util.Objects;

@Component
public class ConnectionListner_delete implements ApplicationListener<SessionConnectedEvent> {

    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        String sessionId = Objects.requireNonNull(event.getUser()).getName(); // Retrieve the session ID
        System.out.println("WebSocket client connected. Session ID: " + sessionId);
    }
}
