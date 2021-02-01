package Core6;

/*  Java_Core 6.10  Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти,
а потом прерви ее используя метод interrupt().
*/

public class Level16Task18 {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread th = new TestThread();
        th.start();
        th.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public void run() {
            System.out.println("Xxx");
        }
    }
}
