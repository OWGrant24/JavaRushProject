package JavaRush.Java_Collections.Collections4.Recursion.task3401_Fibonacci;
/* Числа Фибоначчи с помощью рекурсии

Почитай про числа Фибоначчи.
Реализуй рекурсивную логику метода fibonacci, где n - это номер элемента в последовательности Фибоначчи.
Не создавай в классе Solution дополнительные поля.

Требования:
В классе Solution не должны быть созданы дополнительные поля.
Метод fibonacci должен принимать порядковый номер искомого числа последовательности Фибоначчи и возвращать его значение.
Метод fibonacci не должен быть статическим.
Метод fibonacci должен быть рекурсивным.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}