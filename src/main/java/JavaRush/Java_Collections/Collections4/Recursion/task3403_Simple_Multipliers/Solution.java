package JavaRush.Java_Collections.Collections4.Recursion.task3403_Simple_Multipliers;

/*
Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекурсивный метод для вычисления простых множителей.
Не создавай в классе Solution дополнительные поля.

Пример:
132

Вывод на консоль:
2 2 3 11

Требования:
В классе Solution не должны быть созданы дополнительные поля.
Метод recurse должен выводить на экран все простые множители числа полученного в качестве параметра (пример в условии).
Метод recurse не должен быть статическим.
Метод recurse должен быть рекурсивным.
*/

public class Solution {  // n
    public void recurse(int n) {
        if (n <= 1)
            return;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().recurse(5);
    }
}
