package JavaRush.Java_Multithreading.Multithreading6;

import java.util.Set;
import java.util.TreeSet;

/*
Солдаты всегда строились, строятся и будут строиться по убыванию роста.
Отсортируй солдат, предварительно подумав,
что лучше использовать при таких условиях - Comparable или Comparator.

Требования:
Класс Soldier должен содержать приватные поля String name и int height.
Класс Soldier должен содержать конструктор с двумя параметрами String name и int height.
Подумай, что лучше использовать, и реализуй Comparable или Comparator.
Класс Soldier должен содержать метод compareTo(Soldier solder).
Метод compareTo(Soldier solder) должен сравнивать двоих солдат, учитывая только их рост.
 Сравнивать объекты нужно с учетом убывания роста солдат.
 */
public class Level26Task02 {
    public static void main(String[] args) {
        Set<Soldier> soldiers = new TreeSet<>();
        soldiers.add(new Soldier("Ivanov", 170));
        soldiers.add(new Soldier("Petrov", 180));
        soldiers.add(new Soldier("Sidorov", 175));

        for (Soldier soldier : soldiers) {
            System.out.println(soldier.name);
        }
    }

    public static class Soldier implements Comparable<Soldier> {
        private String name;
        private int height;

        public Soldier(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Soldier o) {
            if(this.height < o.height){
                return 1;
            } else if (o.height < this.height) {
                return -1;
            }
            return 0;
        }
    }
}
//Petrov, Sidorov, Ivanov

