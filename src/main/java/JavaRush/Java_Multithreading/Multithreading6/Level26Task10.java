package JavaRush.Java_Multithreading.Multithreading6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Разберись с BlockingQueue.
По образу и подобию класса Producer создай класс Consumer,
который будет выводить данные из BlockingQueue в консоль.
Требования:
Класс Consumer должен быть создан в отдельном файле.
Класс Consumer должен реализовывать интерфейс Runnable.
Класс Consumer должен содержать приватное поле BlockingQueue queue.
Класс Consumer должен содержать конструктор с одним параметром, инициализирующий поле queue.
Метод run() класса Consumer должен постоянно выводить на экран значения из очереди.
 */
public class Level26Task10 {
    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(32);

        Level26Task10_Producer producer = new Level26Task10_Producer(queue);
        Level26Task10_Consumer consumer = new Level26Task10_Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();

    }
}
