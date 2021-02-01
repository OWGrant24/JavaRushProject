package Java_Multithreading.Multithreading3;
/*
Напряги извилины!
Метод printName должен выводить имя собственного объекта,
т.е. "The Darkside Hacker"
Сделайте минимум изменений.
*/

public class Level23Task10 {
    private String name;

    Level23Task10(String name) {
        this.name = name;
    }

    public String getName() { // если приват - то Риша
        return name;
    }

    private void sout() {
        new Level23Task10("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
//                System.out.println(Level23Task10.this.getName()); // Для компиляции это надо убрать (тут будет выведено Риша)
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Level23Task10("Риша").sout();
    }
}