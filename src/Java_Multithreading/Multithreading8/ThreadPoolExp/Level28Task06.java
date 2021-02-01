package Java_Multithreading.Multithreading8.ThreadPoolExp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/*
1. В методе main создай фиксированный пул из 5 трэдов используя класс Executors.
2. В цикле отправь на исполнение в пул 10 задач Runnable.
3. У каждой задачи в методе run вызови метод doExpensiveOperation с
порядковым номером задачи начиная с 1, см. пример вывода.
4. Запрети добавление новых задач на исполнение в пул (метод shutdown).
5. Дай пулу 5 секунд на завершение всех задач (метод awaitTermination и параметр TimeUnit.SECONDS).
Требования:
Используя класс Executors, создай в методе main фиксированный пул из 5 трэдов.
Пул должен принимать на исполнение 10 задач Runnable.
Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
Запрети добавление новых задач на исполнение в пул.
На завершение всех задач в пуле нужно установить 5 секунд.
 */

public class Level28Task06 {
    static int  localid = 1;
    public static void main(String[] args) throws InterruptedException {
        //Add your code here
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i< 10; i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(localid++);
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(5,TimeUnit.SECONDS);

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}