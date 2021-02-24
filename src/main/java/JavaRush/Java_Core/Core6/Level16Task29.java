package JavaRush.Java_Core.Core6;

/*
1. В классе Solution создать public static класс нити Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используй join.

Пример:

Входные данные:
a
b
c
d
e
f

Выходные данные:
a b c
d e f
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Level16Task29 {
    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.printResult();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        String a;
        public void run() {
            BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
            try {
                 a = reader.readLine() + " " + reader.readLine() + " " + reader.readLine() ;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void printResult() {
            System.out.println(a);
        }

    }
}
