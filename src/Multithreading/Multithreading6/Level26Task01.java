package Multithreading.Multithreading6;

import java.util.Arrays;
import java.util.Comparator;
/*
Реализуй логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы.
Верни отсортированный массив от минимального расстояния до максимального.
Если удаленность одинаковая у нескольких чисел, то сортируй их в порядке возрастания.

Пример входящего массива:
13, 8, 15, 5, 17
медиана - 13

Отсортированный масив:
13, 15, 17, 8, 5

Требования:
Программа не должна выводить текст в консоль.
Программа не должна считывать данные с консоли.
Класс Solution должен содержать публичный статический метод Integer[] sort(Integer[] array).
Метод sort(Integer[] array) класса Solution должен сортировать данные в массиве
по удаленности от его медианы.
 */
public class Level26Task01 {
    public static void main(String[] args) {
        Integer[] arr = {13, 8, 16, 5, 17, 155, 1, 21 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static Integer[] sort(Integer[] array) {
        double mediana = 0;
        Arrays.sort(array);
        int indexMediana = array.length / 2;

        if (array.length % 2 != 0) {   // Поиск медианы для нечетного массива
            mediana = array[indexMediana]; // Медиана получена
            //System.out.println("Медиана нечетного массива : " + mediana);
        } else { // Поиск медианы для четного массива
            mediana = ((double)array[indexMediana-1]+array[indexMediana])/2; // Медиана получена
            System.out.println("Медиана четного массива : " + mediana);
        }
        double finalMediana = mediana;
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                double a = Math.abs(finalMediana - o1);  //2
                double b = Math.abs(finalMediana - o2);  //3
                if (a > b) {
                    return 1;
                } else if (a < b) {
                    return -1;
                } else {
                    return o1<=o2 ? -1 : 1;
                }
            }
        };
        Arrays.sort(array,comparator);
        return array;
    }
}
