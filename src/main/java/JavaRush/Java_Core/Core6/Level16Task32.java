package JavaRush.Java_Core.Core6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*  Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()
 */
public class Level16Task32 {
    public static List<Thread> threads = new ArrayList<>(5);
    static boolean isCancel = false;

    static {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread3();
        Thread t4 = new Thread4();
        Thread t5 = new Thread5();

        threads.add(t1);
        threads.add(t2);
        threads.add(t3);
        threads.add(t4);
        threads.add(t5);

    }

    public static void main(String[] args) {
        //threads.get(0).start();
        //threads.get(1).start();
        //threads.get(2).start();
        threads.get(3).start();
        //threads.get(4).start();
    }

    public static class Thread1 extends Thread { // Работает
        public void run() {
            while (true) {
                System.out.println("1 нить");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread2 extends Thread { // Работает
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("2 нить");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread { // Работает
        public void run() {
            System.out.println("3 нить");
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Thread4 extends Thread implements Level16Task32Message {

        public void run() {
            System.out.println("4 нить");

            while (!isInterrupted()) {

                }
            }


        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static class Thread5 extends Thread { // Работает
        public void run() {
            System.out.println("5 нить");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int x = 0;
            int b;
            while (true) {
                try {
                    String a = reader.readLine();
                    if (!a.equals("N")) {
                        b = Integer.parseInt(a);
                        x = b + x;
                        System.out.println(x);
                    } else {
                        System.out.println(x);
                        reader.close();
                        break;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


