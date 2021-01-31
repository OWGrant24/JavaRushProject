package Multithreading.Multithreading7;
/*
Расставь wait-notify.

Пример вывода:
Thread-0 MailServer received: [Person [Thread-1] wrote an email 'AAA'] in 1001 ms after start
 */
public class Level27Task10 {
    public static void main(String[] args) {
        Level27Task10_Mail mail = new Level27Task10_Mail();
        Thread server = new Thread(new Level27Task10_MailServer(mail));
        Thread amigo = new Thread(new Level27Task10_Person(mail));

        server.start();
        amigo.start();
    }
}
