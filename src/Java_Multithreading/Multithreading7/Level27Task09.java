package Java_Multithreading.Multithreading7;
/*
В классе TransferObject расставь вызовы методов wait/notify/notifyAll,
чтобы обеспечить последовательное создание и получение объекта.
В методах run классов ConsumerTask и ProducerTask создай необходимые synchronized блоки.

Ожидаемый вывод:
...
Put: M
Got: M
Put: N
Got: N
Put: K
Got: K
...
где M, N, K - числа
Метод main не участвует в тестировании

P.S. Всегда старайся использовать concurrent коллекции вместо ручной реализации wait/notify/notifyAll.
Задачи подобные этой позволяют лучше понять основы работы многопоточных приложений.

 */
public class Level27Task09 {
    public static void main(String[] args) throws InterruptedException {
        Level27Task09_TransferObject transferObject = new Level27Task09_TransferObject();
        Level27Task09_ProducerTask producerTask = new Level27Task09_ProducerTask(transferObject);
        Level27Task09_ConsumerTask consumerTask = new Level27Task09_ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
}

