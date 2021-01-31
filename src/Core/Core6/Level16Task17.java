package Core6;

/*    Core 6.10 Отсчет на гонках
1. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через
пробел выдавался отсчет начиная с numSeconds до 1, а потом
слово  [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее
методом interrupt и внутри нити выведи в консоль слово [Прервано!].

Пример для numSeconds=4 :
"4 3 2 1 Прервано!"

4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для numSeconds=3 :
"3 2 1 Марш!"

PS: метод sleep выбрасывает InterruptedException.
*/

public class Level16Task17 {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            Thread current = Thread.currentThread();

            try {
                while (!(current.isInterrupted())) {
                    if (numSeconds !=0) {
                        System.out.println(numSeconds);
                        numSeconds--;
                    }
                    else if (numSeconds == 0) {
                        System.out.println("Марш!");
                        break;
                    }
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
        }
    }

}
