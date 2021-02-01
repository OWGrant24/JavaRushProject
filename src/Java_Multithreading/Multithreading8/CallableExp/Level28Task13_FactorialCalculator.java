package Java_Multithreading.Multithreading8.CallableExp;

import java.util.concurrent.Callable;

public class Level28Task13_FactorialCalculator implements Callable {
    private final int number;

    public Level28Task13_FactorialCalculator(int number) {
        this.number = number;
    }

    @Override
    public Long call() throws InterruptedException {
        return factorial(number);
    }

    public long factorial(int number) throws InterruptedException {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be greater than zero");
        }
        long result = 1;
        while (number > 1) {
            Thread.sleep(1);
            result = result * number;
            number--;
        }
        return result;
    }
}
