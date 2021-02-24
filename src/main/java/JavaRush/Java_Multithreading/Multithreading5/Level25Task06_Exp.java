package JavaRush.Java_Multithreading.Multithreading5;

public class Level25Task06_Exp implements Runnable {

    @Override
    public void run() {
        System.out.println("Привет Мир");
        try {
            Thread.sleep(666);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Привет БРО");
    }
}
