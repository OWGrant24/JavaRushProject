package JavaRush.Java_Multithreading.Multithreading6;

import java.util.concurrent.BlockingQueue;

public class Level26Task10_Producer implements Runnable {
    private BlockingQueue queue;

    public Level26Task10_Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            int i = 0;
            while (true) {
                queue.put(String.valueOf(i++));
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}