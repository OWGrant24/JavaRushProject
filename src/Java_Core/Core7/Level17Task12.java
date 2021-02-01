package Java_Core.Core7;


import java.util.ArrayList;
import java.util.List;
/*
1.Разберись, что делает программа. Официант почему-то
не относит приготовленные блюда назад к столам :(
2.Исправь ошибку.
Подсказка: это одна строчка
 */
public class Level17Task12 {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Level17Task12_Waiter waiterTarget = new Level17Task12_Waiter();  // официаинт
        Thread waiter = new Thread(waiterTarget);
        threads.add(waiter);

        Level17Task12_Cook cookTarget = new Level17Task12_Cook();   // Процесс готовки
        Thread cook = new Thread(cookTarget);
        threads.add(cook);

        waiter.start();
        cook.start();

        Thread.sleep(2000);
        cookTarget.continueWorking = false;
        Thread.sleep(500);
        waiterTarget.continueWorking = false;
    }
}