package JavaRush.Java_Multithreading.Multithreading9;

import java.math.BigDecimal;
/*
Исправь ошибку реализации, приводящую к погрешности вычисления, в методе getValue().
Сигнатуру метода не менять. Округление не использовать.
Читай доп. статью про особенности автобоксинга.
Требования:
Метод getValue() должен создавать два объекта типа BigDecimal.
Метод getValue() должен вызывать метод add() у созданного объекта BigDecimal.
Метод getValue() НЕ должен использовать метод round().
Метод getValue() должен возвращать результат без погрешности.
 */
public class Level29Task07 {
    public static void main(String[] args) {
        System.out.println(getValue(1.1d, 1.2d));
    }

    public static BigDecimal getValue(double v1, double v2) {
        return new BigDecimal(String.valueOf(v1)).add(new BigDecimal(String.valueOf(v2)));
    }
}
