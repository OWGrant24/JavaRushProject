package Core6;

/*  Java_Core 6.13
Разберись, как работает программа.
По образу и подобию CountdownRunnable создай нить 
CountUpRunnable, которая выводит значения в нормальном
порядке - от 1 до number.
*/

public class Level16Task26 {
    public static int number = 5;

    public static void main(String[] args) {
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();
    }

    public static class CountUpRunnable implements Runnable {
        //Add your code here - добавь код тут
        private int countIndexUp = 1;

        public void run() {
            try {
                while (true) {
                    Thread.sleep(500);
                    System.out.println(toString());
                    countIndexUp++;
                    if(countIndexUp == Level16Task26.number+1) {
                        return;
                    }
                }
            } catch (InterruptedException e) {
            }
        }
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUp;
        }
    }

    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Level16Task26.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
