package Multithreading.Multithreading6;

import java.util.concurrent.BlockingQueue;

public class Level26Task10_Consumer implements Runnable {
    private BlockingQueue queue;

    public Level26Task10_Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                String a = (String) queue.poll();
                System.out.println(a);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
