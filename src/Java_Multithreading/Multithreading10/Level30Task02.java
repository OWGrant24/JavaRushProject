package Java_Multithreading.Multithreading10;

/*
Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem,
 который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
 Требования:
В классе Solution должен существовать метод convertToDecimalSystem(String), возвращающий String.
Метод convertToDecimalSystem(String) должен иметь модификаторы доступа: public, static.
Метод convertToDecimalSystem(String) должен вызывать метод Integer.parseInt(String, int).
Метод convertToDecimalSystem(String) должен переводить переданную строку в десятичное число и возвращать его в виде строки.
 */
public class Level30Task02 {
    public static void main(String[] args) {
        String a = convertToDecimalSystem("0x16");
        System.out.println(a); //22
        String b = convertToDecimalSystem("012");
        System.out.println(b);  //10
        String c = convertToDecimalSystem("0b10");
        System.out.println(c); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        String x;
        int r;
        if (s.matches("^0x\\w+")) {
            x = s.substring(2);
            r = 16;
        } else if (s.matches("^0\\d+")) {
            x = s.substring(1);
            r = 8;
        } else if (s.matches("^0b\\d+")) {
            x = s.substring(2);
            r = 2;
        } else {
            x = s;
            r = 10;
        }
        Integer number = null;
        try {
            number = Integer.parseInt(x, r);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(number);
    }
}
