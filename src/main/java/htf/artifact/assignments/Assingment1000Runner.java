package htf.artifact.assignments;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Assingment1000Runner implements CommandLineRunner {

    private Assignment1000 assignment1000;

    public Assingment1000Runner(Assignment1000 assignment1000) {
        this.assignment1000 = assignment1000;
    }

    @Override
    public void run(String... args) throws Exception {
        assignment1000.solveSudoku();
    }
}
