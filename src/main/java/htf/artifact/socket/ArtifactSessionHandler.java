package htf.artifact.socket;

import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

public class ArtifactSessionHandler extends StompSessionHandlerAdapter {
    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Message message = (Message) payload;
        System.out.println(message.toString());
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        session.subscribe("/websocket/artifact", this);
    }
}
