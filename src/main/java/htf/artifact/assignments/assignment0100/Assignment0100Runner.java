package htf.artifact.assignments.assignment0100;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Assignment0100Runner implements ApplicationRunner {

    final Assignment0100Queue queue;

    public Assignment0100Runner(Assignment0100Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        queue.send("future-the-hack");
        System.out.println("send");
    }
}
