package htf.artifact.assignments.assignment0100;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class Assignment0100Queue {

    private final RabbitTemplate template;

    private final Queue queue;

    public Assignment0100Queue(RabbitTemplate template, Queue queue) {
        this.template = template;
        this.queue = queue;
    }
    
    private void send(String message, Queue queue) {
        this.template.convertAndSend(queue.getName(), message);

    }
}
