package htf.artifact.assignments.assignment0100;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class Assignment0100Queue {

    private final RabbitTemplate template;

    private final Queue queue;

    public Assignment0100Queue(RabbitTemplate template, Queue queue) {
        this.template = template;
        this.queue = queue;
    }

    public void send(String message) {
        this.template.convertAndSend(queue.getName(), message);
    }
}
