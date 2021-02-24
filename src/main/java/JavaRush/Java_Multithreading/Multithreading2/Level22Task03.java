package JavaRush.Java_Multithreading.Multithreading2;

import java.util.Arrays;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
 */
public class Level22Task03 {
    public static String getPartOfString(String string) throws TooShortStringException {
        try {
            String[] strings = string.split("\t");
            System.out.println(Arrays.toString(strings));
            System.out.println(strings.length);
            if (strings.length < 3) {
                throw new TooShortStringException();
            }
            return strings[1];
        } catch (Exception e) {
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java."));
        System.out.println(getPartOfString(null));
    }
}