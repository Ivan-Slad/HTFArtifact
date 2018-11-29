package htf.artifact.assignments.assignment1000;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Assignment1000Runner implements CommandLineRunner {

    private Assignment1000 assignment1000;

    public Assignment1000Runner(Assignment1000 assignment1000) {
        this.assignment1000 = assignment1000;
    }

    @Override
    public void run(String... args) throws Exception {
        assignment1000.solveSudoku();
    }
}
