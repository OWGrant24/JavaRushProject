package Multithreading.Multithreading5;
/*
Не валять дурака
Восстанови логику класса TaskManipulator.
*/

public class Level25Task08 {
    /*
         Output:
         first
         first
         second
         second
         second
         third
         fifth
         */
    public static void main(String[] args) throws InterruptedException {
        Level25Task08_CustomThreadManipulator manipulator = new Level25Task08_TaskManipulator();

        manipulator.start("first");
        Thread.sleep(150);
        manipulator.stop();
//        System.out.println("Main : " + Thread.currentThread().getName());
        manipulator.start("second");
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
        manipulator.stop();
    }
}