package Java_Multithreading.Multithreading7;

public class Level27Task10_Person implements Runnable {
    private final Level27Task10_Mail mail;

    public Level27Task10_Person(Level27Task10_Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            synchronized (mail) {
                //сделайте что-то тут - do something here
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
                //сделайте что-то тут - do something here
                mail.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
