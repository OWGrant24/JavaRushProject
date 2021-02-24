package JavaRush.Java_Multithreading.Multithreading3;
/*
Повторяем threads
Сделать так, чтобы в методе someActions вызывались только методы класса Solution (Level23Task11).

Ожидаемый вывод в методе main:
Amigo: Mmmmm, beef
Amigo: knock knock
Amigo: Zzzzzzz...1 s
*/
public class Level23Task11 {
    public final String name;
    public final String food;
    public final String sound;

    public Level23Task11(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    someActions();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                Level23Task11.this.eat();
                Level23Task11.this.play();
                Level23Task11.this.sleep(1000);
            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Level23Task11("Amigo", "beef", "knock").live();
    }
}