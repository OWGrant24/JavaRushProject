package JavaRush.Java_Multithreading.Multithreading10;

import java.util.concurrent.TransferQueue;

public class Level30Task03_Consumer implements Runnable {
    private TransferQueue<Level30Task03_ShareItem> queue;

    public Level30Task03_Consumer(TransferQueue<Level30Task03_ShareItem> queue) {
        this.queue = queue;
    }

    /*
    5. Реализация метода run для Consumer:
    5.1. Усыпи трэд на 0.45 секунды.
    5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль "Processing item.toString()".
     */
    @Override
    public void run() {
        try {
            Thread.sleep(450);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (!Thread.currentThread().isInterrupted()) {
            Level30Task03_ShareItem item = null;
            try {
                item = queue.take();
                System.out.format("Processing %s\n",item.toString());
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
