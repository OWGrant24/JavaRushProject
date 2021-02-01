package Java_Multithreading.Multithreading8;


public class Level28Task05_MyThread extends Thread {
    private static int priority = Thread.MIN_PRIORITY;
    {
        setPriority(priority++);
        if(priority>Thread.MAX_PRIORITY) priority = Thread.MIN_PRIORITY;
    }

    public Level28Task05_MyThread() {
    }

    public Level28Task05_MyThread(Runnable target) {
        super(target);
    }

    public Level28Task05_MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public Level28Task05_MyThread(String name) {
        super(name);
    }

    public Level28Task05_MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public Level28Task05_MyThread(Runnable target, String name) {
        super(target, name);
    }

    public Level28Task05_MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public Level28Task05_MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
