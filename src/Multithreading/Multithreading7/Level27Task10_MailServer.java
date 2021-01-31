package Multithreading.Multithreading7;

public class Level27Task10_MailServer implements Runnable {
    private Level27Task10_Mail mail;

    public Level27Task10_MailServer(Level27Task10_Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        //сделайте что-то тут - do something here
        try {
            synchronized (mail) {
                mail.wait();
                String name = Thread.currentThread().getName();
                long endTime = System.currentTimeMillis();
                System.out.format("%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
