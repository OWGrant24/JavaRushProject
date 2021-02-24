package JavaRush.Java_Collections.Collections2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/*
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream,
в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu

Класс Solution должен содержать метод getPassword(),
который возвращает ByteArrayOutputStream со сгенерированным паролем.
Длина пароля должна составлять 8 символов.
Пароль должен содержать хотя бы одну цифру.
Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
Сгенерированные пароли должны быть уникальными.
 */
public class Level32Task04 {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        Random random = new Random();
        int a = 48 + random.nextInt(9);
        System.out.println("Строка а - " + a);
        byteArrayOutputStream.write(a);
        int b = 65 + random.nextInt(25);
        System.out.println("Строка b - " + b);
        byteArrayOutputStream.write(b);
        int c = 97 + random.nextInt(25);
        System.out.println("Строка c - " + c);
        byteArrayOutputStream.write(c);
        for (int i = 0; i < 5; i++) {
            int a1 = 48 + random.nextInt(9);
            int b1 = 65 + random.nextInt(25);
            int c1 = 97 + random.nextInt(25);
            int[] variant = {a1, b1, c1};
            byteArrayOutputStream.write(variant[random.nextInt(2)]);
        }
        return byteArrayOutputStream;
    }
}
