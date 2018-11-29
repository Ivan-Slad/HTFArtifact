package htf.artifact.assignments.assignment0100;

import htf.artifact.base64Decoding.ImageStringDecoder;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "team-38")
public class Assignment0100Receiver {
    public static String solution="";

    private final ImageStringDecoder imageStringDecoder;

    private final String path;

    public Assignment0100Receiver(ImageStringDecoder imageStringDecoder, @Value("${images}") String path) {
        this.imageStringDecoder = imageStringDecoder;
        this.path = path;
    }

    @RabbitHandler
    public void receive(String in){
        System.out.println(in);
        StringBuilder sb = new StringBuilder(in);
        String response = sb.substring(sb.indexOf("/"));
        System.out.println(response);
        imageStringDecoder.decodeToImage(response, path + "/image0100.png");
    }
}
