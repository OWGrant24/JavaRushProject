package JavaRush.Java_Multithreading.Multithreading10;

import java.util.concurrent.TransferQueue;

public class Level30Task03_Producer implements Runnable {
    private TransferQueue<Level30Task03_ShareItem> queue;

    public Level30Task03_Producer(TransferQueue<Level30Task03_ShareItem> queue) {
        this.queue = queue;
    }

    /*
    4. Реализация метода run для Producer:
    4.1. Используя метод offer добавь в очередь 9 ShareItem-ов с такими параметрами:
    ("ShareItem-N", N), где N - номер элемента от 1 до 9.
    4.2. Перед каждым добавлением выведи фразу "Элемент 'ShareItem-N' добавлен". Используй System.out.format.
    4.3. Усыпи трэд на 0.1 секунды.
    4.4. Если у очереди есть Consumer, не занятый работой, то выведи фразу "Consumer в ожидании!".
    Просмотри методы интерфейса TransferQueue, там есть нужный метод.
     */
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 9; i++) {
                System.out.format("Элемент 'ShareItem-%d' добавлен\n", i);
                queue.offer(new Level30Task03_ShareItem("ShareItem-" + i, i));
                Thread.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!\n");
                }
            }
        } catch (InterruptedException ignored) {
        }
    }
//    public void run() {
//        for (int i = 1; i <= 9; i++) {
//            if (Thread.currentThread().isInterrupted()) {
//                break;
//            }
//            String description = "ShareItem-" + i;
//
//            queue.offer(new Level30Task03_ShareItem(description, i));
//            System.out.format("Элемент '%s' добавлен\n", description);
//        }
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException ignored) {
//        }
//        if (queue.hasWaitingConsumer()) {
//            System.out.format("Consumer в ожидании!\n");
//        }
//
//    }
}

