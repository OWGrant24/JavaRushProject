package Java_Multithreading.Multithreading10.ForkJoinExp;
/*
1. Создай класс BinaryRepresentationTask. Для этого в IntelliJ IDEA на красном имени класса нажми Alt+Enter -> Create Class ...
(класс должен наследоваться от RecursiveTask<String>). Параметр конструктора - int x.
2. Реализуй логику метода compute - число должно переводиться в двоичное представление.
3. Используй методы fork и join.
4. Пример функциональной реализации - метод binaryRepresentationMethod.

Требования:
Создай класс BinaryRepresentationTask.
В классе BinaryRepresentationTask должен быть переопределен метод compute().
В классе BinaryRepresentationTask в методе compute() используй методы fork() и join().
Метод compute() должен правильно переводить число в двоичную систему счисления.
 */

import java.util.concurrent.ForkJoinPool;

public class Level30Task04 {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        Level30Task04 solution = new Level30Task04();
        String result1 = solution.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new Level30Task04_BinaryRepresentationTask(6));
        System.out.println(result2);
    }
}
