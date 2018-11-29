package htf.artifact.assignments.assignment0100;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "team-38")
public class Assignment0100Receiver {
    public static String solution="";

    @RabbitHandler
    public void receive(String in){
        char input = (char) Integer.parseInt(in,2);
        solution+=input;
        System.out.println(solution);
    }
}
