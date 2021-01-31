package Multithreading.Multithreading5;

public class Level25Task04 {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for(Thread thread : threads){
            switch (thread.getState()){
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                    thread.interrupt();
                    break;
                case BLOCKED:
                    thread.interrupt();
                    break;
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Мэн не копируй
        Thread thread = new Thread();
        thread.start();
        processThreads(thread);
        thread.join();
        processThreads(thread);
        thread.interrupt();
        processThreads(thread);



    }
}
