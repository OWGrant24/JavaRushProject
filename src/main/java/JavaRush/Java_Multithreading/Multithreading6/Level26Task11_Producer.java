package JavaRush.Java_Multithreading.Multithreading6;

import java.util.concurrent.ConcurrentHashMap;

public class Level26Task11_Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;
    public Level26Task11_Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }
/*
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение,
где ключ - счетчик начиная с 1, значение - фраза: "Some text for i" , пример "Some text for 1".
2. при возникновении исключения выводить в консоль: "[THREAD_NAME] thread was terminated",
пример "[thread-1] thread was terminated".
 */
    @Override
    public void run() {
        try{
            for (int i = 1; true; i++) {
                map.put(String.valueOf(i),"Some text for " + i);
                Thread.sleep(500);
            }
        } catch (Exception e){
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
