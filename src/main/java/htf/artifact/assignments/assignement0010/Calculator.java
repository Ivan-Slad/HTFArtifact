package htf.artifact.assignments.assignement0010;

import java.util.*;

public class Calculator {
    List<Integer> getFibonacci(int max) {
        List<Integer> response = new ArrayList<>();
        boolean prime;
        boolean fibonacci;
        int firstFibo = 0;
        int secondFibo = 1;
        for (int i = 1; i <= max; i++) {
            fibonacci = false;
            prime = true;
            // If prime[p] is not changed, then
            // it is a prime
            // Update all multiples of p
            if (i == firstFibo + secondFibo) {
                fibonacci = true;
                firstFibo = secondFibo;
                secondFibo = i;
            }

            if (fibonacci) {
                if (i == 1) {
                    prime = false;
                }
                for (int j = 2; j < i / 2; j++) {
                    if (i % j == 0) {
                        prime = false;

                    }
                }
            }
            if (prime && fibonacci) {
                response.add((Integer) i);
            }
        }
        return response;
    }
}
