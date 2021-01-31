package Multithreading.Multithreading5;


/*
Cоздай класс нити LoggingStateThread, которая будет выводить в консоль все
состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.
 */
public class Level25Task06 {
    public static void main(String[] args) throws InterruptedException {
        Level25Task06_Exp exp = new Level25Task06_Exp();
        Thread target = new Thread(exp);
        Level25Task06_LoggingStateThread loggingStateThread = new Level25Task06_LoggingStateThread(target);

        loggingStateThread.start(); //NEW
        Thread.sleep(100);
        target.start();  //RUNNABLE
        Thread.sleep(100);
        //TERMINATED
    }
}
