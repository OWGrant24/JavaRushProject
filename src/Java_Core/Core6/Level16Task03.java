package Core6;

/*  Java_Core 6.3
В методе main добавить в статический объект list 5 нитей.
Каждая нить должна быть новым объектом класса Thread,
работающим со своим объектом класса SpecialThread.
*/

import java.util.ArrayList;
import java.util.List;

public class Level16Task03 {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread st1 = new SpecialThread();
        Thread thread1 = new Thread(st1);
        SpecialThread st2 = new SpecialThread();
        Thread thread2 = new Thread(st2);
        SpecialThread st3 = new SpecialThread();
        Thread thread3 = new Thread(st3);
        SpecialThread st4 = new SpecialThread();
        Thread thread4 = new Thread(st4);
        SpecialThread st5 = new SpecialThread();
        Thread thread5 = new Thread(st5);

        list.add(thread1);
        list.add(thread2);
        list.add(thread3);
        list.add(thread4);
        list.add(thread5);

    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
