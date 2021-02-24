package JavaRush.Java_Core.Core6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*    Java_Core 6.10
Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое
прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.
*/

public class Level16Task16 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            try {
                //add your code here - добавьте код тут
                Thread currentThread = new Thread();
                while (!(currentThread.isInterrupted())) {
                    Thread.sleep(1000);
                    seconds++;
                }
            } catch (InterruptedException e) {
                System.out.println(seconds);
            }
        }
    }
}