package Java_Multithreading.Multithreading5;

public class Level25Task08_TaskManipulator implements Runnable, Level25Task08_CustomThreadManipulator{
    private Thread thread;
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            System.out.println(current.getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();

    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
