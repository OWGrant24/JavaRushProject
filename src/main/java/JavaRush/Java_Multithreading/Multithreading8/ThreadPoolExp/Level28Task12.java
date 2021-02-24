package JavaRush.Java_Multithreading.Multithreading8.ThreadPoolExp;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
Разберись в чем отличие методов shutdown и shutdownNow. Выведи список всех незавершенных задач на экран.

Должно получиться что-то вроде:
pool-1-thread-1, localId=1
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
java.util.concurrent.FutureTask@7e6cbb7a was not completed
java.util.concurrent.FutureTask@7c3df479 was not completed
java.util.concurrent.FutureTask@7106e68e was not completed
java.util.concurrent.FutureTask@7eda2dbb was not completed
java.util.concurrent.FutureTask@6576fe71 was not completed
Требования:
В методе main класса Solution должен быть вызван метод shutdownNow на объекте executor.
В методе main класса Solution на экран должны быть выведены все задачи которые не успел выполнить executor.
Метод main должен быть публичным.
Метод main должен быть статическим.
 */
public class Level28Task12 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }
        List<Runnable> runnableList = executor.shutdownNow();
        Thread.sleep(100);
        for(Runnable r : runnableList){
            System.out.println(r.toString() + " was not completed");
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}