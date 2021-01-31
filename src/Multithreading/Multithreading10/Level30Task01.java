package Multithreading.Multithreading10;

import java.math.BigInteger;

/*
Реализуй логику метода convertNumberToOtherNumberSystem, который должен переводить число number.getDigit(),
 из одной системы счисления (numberSystem) в другую (expectedNumberSystem).
Брось NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2.
Валидация для - number.getDigit() - целое не отрицательное.
Метод main не участвует в тестировании.
Требования:
Метод convertNumberToOtherNumberSystem (Number, NumberSystem), возвращающий тип Number, должен существовать.
Должно бросаться исключение NumberFormatException, если переданное число некорректно в заданной системе счисления.
Необходимо корректно реализовать метод convertNumberToOtherNumberSystem - перевод числа в указанную систему счисления.
Enum NumberSystemType должен поддерживать интерфейс NumberSystem.
В enum-е NumberSystemType должно присутствовать 11 значений оснований систем счисления.
Основания: 2, 3, 4, 5, 6, 7, 8, 9, 10, 12 и 16.
 */
public class Level30Task01 {
    public static void main(String[] args) {
        Level30Task01_Number number = new Level30Task01_Number(Level30Task01_NumberSystemType._10, "6");
        Level30Task01_Number result = convertNumberToOtherNumberSystem(number, Level30Task01_NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Level30Task01_Number(Level30Task01_NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, Level30Task01_NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Level30Task01_Number(Level30Task01_NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, Level30Task01_NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef

        number = new Level30Task01_Number(Level30Task01_NumberSystemType._2, "120");
        result = convertNumberToOtherNumberSystem(number, Level30Task01_NumberSystemType._16);
        System.out.println(result);
    }

    public static Level30Task01_Number convertNumberToOtherNumberSystem(Level30Task01_Number number, Level30Task01_NumberSystem expectedNumberSystem) {
        //напишите тут ваш код

        String s = null;
        try {
            BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());
            s = bigInteger.toString(expectedNumberSystem.getNumberSystemIntValue());
            return new Level30Task01_Number(expectedNumberSystem,s);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
