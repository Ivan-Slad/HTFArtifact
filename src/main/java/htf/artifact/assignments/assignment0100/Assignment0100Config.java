package htf.artifact.assignments.assignment0100;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.*;

@Configuration
public class Assignment0100Config {
    @Bean
    public Queue queue(){
        return new Queue("teamReply-38");
    }
}
