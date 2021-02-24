package JavaRush.Java_Multithreading.Multithreading7;

import java.util.concurrent.atomic.AtomicInteger;

public class Level27Task09_ProducerTask implements Runnable {
    private Level27Task09_TransferObject transferObject;
    protected volatile boolean stopped;
    static volatile AtomicInteger i = new AtomicInteger(0);

    public Level27Task09_ProducerTask(Level27Task09_TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ProducerTask").start();
    }

    public void run() {
        while (!stopped) {
            synchronized (this) {
                transferObject.put(i.incrementAndGet());
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}

