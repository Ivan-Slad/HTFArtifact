package htf.artifact;

import htf.artifact.socket.ArtifactSessionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.Scanner;

@SpringBootApplication
public class ArtifactApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtifactApplication.class, args);
        WebSocketClient webSocketClient = new StandardWebSocketClient();
        WebSocketStompClient webSocketStompClient = new WebSocketStompClient(webSocketClient);
        webSocketStompClient.setMessageConverter(new MappingJackson2MessageConverter());

        StompSessionHandler sessionHandler = new ArtifactSessionHandler();
        webSocketStompClient.connect("ws://34.242.133.196:8090", sessionHandler);

        new Scanner(System.in).nextLine();

    }
}
