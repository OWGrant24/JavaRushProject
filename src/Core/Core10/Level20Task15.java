package Core.Core10;

import java.io.*;
/*
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.

Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.

 */
public class Level20Task15 implements Runnable, Serializable {
    transient private Thread runner;
    private int speed;

    public Level20Task15(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // Сделай что нибудь здесь, неважно что
        System.out.println(speed);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread runnel = new Thread(this);
        runnel.start();
    }

    public static void main(String[] args) {
        Level20Task15 lv = new Level20Task15(88);
    }
}
