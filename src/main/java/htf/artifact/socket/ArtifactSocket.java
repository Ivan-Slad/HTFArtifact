package htf.artifact.socket;

import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.net.URI;

@ClientEndpoint
public class ArtifactSocket {


    private static Object waitLock = new Object();

    @OnMessage
    public void onMessage(String message) {
        System.out.println("Received msg: " + message);
    }

    public static void main(String[] args) {
        WebSocketContainer container = null;
        Session session = null;
        try {
            container = ContainerProvider.getWebSocketContainer();
            session = container.connectToServer(ArtifactSocket.class, URI.create("ws://34.242.133.196:8090/websocket/artifact"));
            wait4TerminateSignal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void wait4TerminateSignal() {
        synchronized (waitLock) {
            try {
                waitLock.wait();
            } catch (InterruptedException e) {
            }
        }
    }
}
