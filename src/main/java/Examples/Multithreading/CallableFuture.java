package Examples.Multithreading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableFuture {
    public static void main(String[] args) throws Exception {
        Callable<Integer> task = new Callable() {
            @Override
            public Integer call() {
                return 5 * new Random().nextInt(89);
            }
        };
        FutureTask<Integer> future = new FutureTask<>(task);
        new Thread(future).start(); //  Создание нового потока и запуск
        System.out.println(future.get());
    }
}
