package JavaRush.Java_Multithreading.Multithreading3;

/*
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution (Level22Task05) инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/

public class Level23Task05 {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Level23Task05[] getTwoSolutions() {
        Level23Task05[] solution = new Level23Task05[2];
        solution[0] = new Level23Task05();
        solution[1] = new Level23Task05();
        solution[0].innerClasses[0] = new Level23Task05().new InnerClass();
        solution[0].innerClasses[1] = new Level23Task05().new InnerClass();
        solution[1].innerClasses[0] = new Level23Task05().new InnerClass();
        solution[1].innerClasses[1] = new Level23Task05().new InnerClass();
        return solution;
    }

    public static void main(String[] args) {
    }
}