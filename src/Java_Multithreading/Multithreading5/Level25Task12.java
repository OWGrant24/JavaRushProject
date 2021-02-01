package Java_Multithreading.Multithreading5;

/*
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен: +
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC

Требования:
Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
После вызова uncaughtException нужно прервать нить, которая бросила исключение.
Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
Сообщения должны выводиться в формате "exception class: exception message".
*/

public class Level25Task12 implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        e.getCause();
        }


    public static void main(String[] args) {
        new Level25Task12().uncaughtException(Thread.currentThread(), new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
    }
}