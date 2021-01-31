package Multithreading.Multithreading7;

public class Level27Task09_ConsumerTask implements Runnable {
    private Level27Task09_TransferObject transferObject;
    protected volatile boolean stopped;

    public Level27Task09_ConsumerTask(Level27Task09_TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        while (!stopped) {
            synchronized (this) {
                transferObject.get();
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}
