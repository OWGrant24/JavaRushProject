package Test;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        // Пул из 2-х потоков
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(int i = 0; i < new Random().nextInt(66); i++){
            executorService.submit(new Work(new Random().nextInt(56))); // Даём задание, в качестве аргмента - конструктор класса
        }
        executorService.shutdown(); // Прекращаем выдавать задания и запускаем поток (аналог start)
        executorService.awaitTermination(1, TimeUnit.HOURS);  // Сколько мы готовы ждать, пока наши потоки выполняют задания.
        // По прошествии этого времени , мы перейдем дальше , если потоки ранее не выполнят задания
        System.out.println("Потоки выполнили свою работу");

    }
    public static class Work implements Runnable {
        private int id;
        public Work(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"Поток запущен");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(id * new Random().nextInt(24));
        }
    }
}
