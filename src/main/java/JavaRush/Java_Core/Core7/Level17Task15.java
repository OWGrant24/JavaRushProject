package JavaRush.Java_Core.Core7;

import java.util.ArrayList;
import java.util.List;
/*
Реализуй интерфейс Runnable в классах Apteka и Person.
Все нити должны работать пока не isStopped.
Логика для Apteka: drugsController должен сделать закупку
(вызвать метод void buy(Drug drug, int count)) случайного лекарства (getRandomDrug) в количестве
(getRandomCount) и подождать 300 мс.
Логика для Person: drugsController должен сделать продажу (вызвать метод void sell(Drug drug, int count))
случайного лекарства (getRandomDrug) в количестве (getRandomCount) и подождать 100 мс.
Расставь synchronized там, где это необходимо.
 */
public class Level17Task15 {
    public static Level17Task15_DrugsController drugsController = new Level17Task15_DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka(), "Apteka");
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    public static class Apteka implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
                drugsController.buy(getRandomDrug(), getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }
        }
    }

    public static class Person implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
                drugsController.sell(getRandomDrug(), getRandomCount());
                    waitAMoment();
            }
        }
    }

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public static Level17Task15_Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (Level17Task15_DrugsController.allDrugs.size()));
        List<Level17Task15_Drug> drugs = new ArrayList<>(Level17Task15_DrugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
