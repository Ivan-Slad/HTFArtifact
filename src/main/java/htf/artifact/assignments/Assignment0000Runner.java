package htf.artifact.assignments;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Assignment0000Runner implements CommandLineRunner {
    private Assignment0000 assignment0000;

    public Assignment0000Runner(Assignment0000 assignment0000) {
        this.assignment0000 = assignment0000;
    }

    @Override
    public void run(String... args) throws Exception {
        assignment0000.decrypt();
    }
}
